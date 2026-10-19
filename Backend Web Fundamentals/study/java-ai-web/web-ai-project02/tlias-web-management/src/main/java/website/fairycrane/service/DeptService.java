package website.fairycrane.service;

import website.fairycrane.pojo.Dept;

import java.time.LocalDateTime;
import java.util.List;

public interface DeptService {
    // 返回部门列表
    List<Dept> getAll();

    // 返回删除操作影响行数
    void deleteById(int id);

    // 返回添加操作影响行数
    void add(Dept dept);

    // 根据id查询返回dept对象
    Dept getInfo(int id);

    // 根据id修改部门名称
    void update(Dept dept);
}
