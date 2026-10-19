package website.fairycrane.mapper;

import org.apache.ibatis.annotations.*;
import website.fairycrane.pojo.Dept;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DeptMapper {
    // 部门列表查询
    // 方式一：手动结果映射
    // @Results({
    //         @Result(column = "create_time", property = "createTime"),
    //         @Result(column = "update_time", property = "updateTime")
    // })
    @Select("select id, name, create_time, update_time from dept order by dept.update_time desc")
    List<Dept> getAll();

    // 删除部门
    @Delete("delete from dept where id = #{id}")
    void deleteById(int id);

    // 添加部门
    @Insert("insert into dept(name,create_time,update_time)  values (#{name},now(),now())")
    void insert(Dept dept);

    // 根据id查询
    // 方式二：起别名进行结果映射
    @Select("select id, name, create_time createTime, update_time updateTime from dept where id=#{id}")
    Dept getById(int id);

    // 修改部门
    @Update("update dept set name = #{name}, update_time=#{createTime} where id = #{id}")
    void update(Dept dept);
}
