package website.fairycrane.mapper;

import org.apache.ibatis.annotations.*;
import website.fairycrane.pojo.Dept;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DeptMapper {
    // 部门列表查询
    @Select("select id, name, create_time, update_time from dept order by dept.update_time desc")
    List<Dept> getAll();

    // 删除部门
    @Delete("delete from dept where id = #{id}")
    Integer delete(int id);

    // 添加部门
    @Insert("insert into dept(name,create_time,update_time)  values (#{name},now(),now())")
    Integer insert(@Param("name") String name);

    // 根据id查询
    @Select("select id, name, create_time, update_time from dept where id=#{id}")
    Dept getById(int id);
}
