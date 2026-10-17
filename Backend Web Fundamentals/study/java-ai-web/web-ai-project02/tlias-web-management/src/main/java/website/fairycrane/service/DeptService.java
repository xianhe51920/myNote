package website.fairycrane.service;

import website.fairycrane.pojo.Dept;

import java.time.LocalDateTime;
import java.util.List;

public interface DeptService {
    // 返回部门列表
    List<Dept> getAll();

    // 返回删除操作是否成功
    boolean delete(int id);

    // 返回添加操作是否成功
    boolean insert(String name);

    // 根据id查询返回dept对象
    Dept getById(int id);

    // 检查增删改是否成功
    boolean success(int num);


}
