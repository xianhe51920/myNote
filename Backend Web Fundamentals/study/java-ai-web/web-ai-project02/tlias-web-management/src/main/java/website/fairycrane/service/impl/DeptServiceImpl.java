package website.fairycrane.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import website.fairycrane.mapper.DeptMapper;
import website.fairycrane.pojo.Dept;
import website.fairycrane.service.DeptService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    private final DeptMapper deptMapper;

    public DeptServiceImpl(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    // 返回部门列表
    @Override
    public List<Dept> getAll() {
        return deptMapper.getAll();
    }

    // 返回删除操作是否成功
    @Override
    public void deleteById(int id) {
        deptMapper.deleteById(id);
    }

    // 返回添加操作是否成功
    @Override
    public void add(Dept dept) {
        // 更新信息
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        // 添加
        deptMapper.insert(dept);
    }

    // 根据id查询部门信息
    @Override
    public Dept getInfo(int id) {
        return deptMapper.getById(id);
    }

    // 修改部门信息
    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
