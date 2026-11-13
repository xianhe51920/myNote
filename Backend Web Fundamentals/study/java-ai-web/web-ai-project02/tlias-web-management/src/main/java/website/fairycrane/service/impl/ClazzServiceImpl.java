package website.fairycrane.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import website.fairycrane.mapper.ClazzMapper;
import website.fairycrane.pojo.Clazz;
import website.fairycrane.pojo.ClazzQueryParam;
import website.fairycrane.pojo.PageResult;
import website.fairycrane.service.ClazzService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;
    @Override
    public PageResult<Clazz> pageResult(ClazzQueryParam clazzQueryParam) {
        // 设置分页参数
        PageHelper.startPage(clazzQueryParam.getPage(),clazzQueryParam.getPageSize());
        // 获取查询结果
        Page<Clazz> list = clazzMapper.list(clazzQueryParam);
        // 返回查询结果
        return new PageResult<Clazz>(list.getTotal(),list.getResult());
    }

    // 根据id删除班级
    @Override
    public void deleteById(Integer id) {
        clazzMapper.deleteById(id);
    }

    //添加班级
    @Override
    public void addClazz(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.addClazz(clazz);
    }

    // 根据id查询班级
    @Override
    public Clazz getClazzById(Integer id) {
        return clazzMapper.getClazzById(id);
    }

    // 修改班级信息
    @Override
    public void updateClazz(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateClazz(clazz);
    }

    // 查询所有班级
    @Override
    public List<Clazz> getClszzList() {
        return clazzMapper.getClazzList();
    }
}
