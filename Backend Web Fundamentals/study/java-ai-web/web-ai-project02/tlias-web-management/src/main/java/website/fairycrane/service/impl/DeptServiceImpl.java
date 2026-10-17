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
    public boolean delete(int id) {
        return success(deptMapper.delete(id));
    }

    // 返回添加操作是否成功
    @Override
    public boolean insert(String name) {
        return success(deptMapper.insert(name));
    }

    @Override
    public Dept getById(int id) {
        return null;
    }

    // 返回增删改操作是否成功
    @Override
    public boolean success(int num) {
        return num > 0;
    }
}
