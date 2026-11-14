package website.fairycrane.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.fairycrane.mapper.EmpExprMapper;
import website.fairycrane.mapper.EmpMapper;
import website.fairycrane.pojo.*;
import website.fairycrane.service.EmpService;
import website.fairycrane.utils.AliyunOSSOperator;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {
    private final EmpMapper empMapper;
    private final EmpExprMapper empExprMapper;
    private final AliyunOSSOperator aliyunOSSOperator;

    @Autowired
    public EmpServiceImpl(EmpMapper empMapper, EmpExprMapper empExprMapper,
                          AliyunOSSOperator aliyunOSSOperator) {
        this.empMapper = empMapper;
        this.empExprMapper = empExprMapper;
        this.aliyunOSSOperator = aliyunOSSOperator;
    }

    @Override
    public PageResult<Emp> pageResult(EmpQueryParam empQueryParam) {
        // 设置分页参数
        PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());
        // 调用查询
        Page<Emp> list = empMapper.list(empQueryParam);
        // 解析
        return new PageResult<Emp>(list.getTotal(),list.getResult());
    }

    // 保存员工基本信息及工作经历
    @Override
    @Transactional(rollbackFor = {Exception.class}) // 表示在Exception异常发生时进行回滚，默认是RunTimeException
    public void save(Emp emp) {
        // 补充基础属性
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            // 保存员工基本信息,自增主键回填到 emp.id
            empMapper.insert(emp);
            // 保存员工工作经历,emp_id 取自回填后的员工主键
            List<EmpExpr> exprList = emp.getExprList();
            if (exprList != null && !exprList.isEmpty()) {
                exprList.forEach(expr -> expr.setEmpId(emp.getId()));
                empExprMapper.insert(exprList);
            }
        } finally {

        }
    }

    // 删除员工信息
    @Override
    @Transactional(rollbackFor = {Exception.class })
    public void delete(List<Integer> ids) {
        if(!ids.isEmpty()){
        // 查询员工头像链接（必须在删除数据前查询）
        List<String> images = empMapper.getImagesByIds(ids);
        // 删除员工工作经历
        empExprMapper.deleteByEmpId(ids);
        // 删除员工基本信息
        empMapper.deleteById(ids);
        // 删除员工云端资源（头像）
        deleteEmpImages(images);
        }
    }
    
    // 删除员工云端资源（头像链接）
    public void deleteEmpImages(List<String> images) {
        for (String image : images) {
            if (image != null && !image.isBlank()) {
                try {
                    aliyunOSSOperator.delete(image);
                } catch (Exception e) {
                    // 云端删除失败不影响主流程，记录日志即可
                    log.error("删除员工头像失败：{}", image, e);
                }
            }
        }
    }
    @Override
    public Emp getInfoById(Integer id) {
        return empMapper.getInfoById(id);
    }

    // 修改员工信息
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Emp emp) {
        //获取id
        Integer id = emp.getId();
        // 补充修改时间
        emp.setUpdateTime(LocalDateTime.now());
        // 根据员工id更新员工基本信息
        empMapper.update(emp);
        // 修改员工工作经历
        // 1.删除原有工作经历
        empExprMapper.deleteByEmpId(Collections.singletonList(id));
        // 2.添加新的工作经历
        // 获取工作经历列表
        List<EmpExpr> exprList = emp.getExprList();
        if (!exprList.isEmpty()){
            exprList.forEach(empExpr -> empExpr.setEmpId(id));
        }
        // 保存新的工作经历
        empExprMapper.insert(exprList);
    }
}