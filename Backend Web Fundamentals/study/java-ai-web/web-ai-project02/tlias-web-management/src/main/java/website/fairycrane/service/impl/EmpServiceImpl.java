package website.fairycrane.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.fairycrane.mapper.EmpExprMapper;
import website.fairycrane.mapper.EmpMapper;
import website.fairycrane.pojo.Emp;
import website.fairycrane.pojo.EmpExpr;
import website.fairycrane.pojo.EmpQueryParam;
import website.fairycrane.pojo.PageResult;
import website.fairycrane.service.EmpService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    private final EmpMapper empMapper;
    private final EmpExprMapper empExprMapper;

    public EmpServiceImpl(EmpMapper empMapper, EmpExprMapper empExprMapper) {
        this.empMapper = empMapper;
        this.empExprMapper = empExprMapper;
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
    public void save(Emp emp) {
        // 补充基础属性
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
    }
}
