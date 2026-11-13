package website.fairycrane.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import website.fairycrane.pojo.Clazz;
import website.fairycrane.pojo.ClazzQueryParam;

import java.util.List;

@Mapper
public interface ClazzMapper {

    Page<Clazz> list(ClazzQueryParam clazzQueryParam);

    // 根据id删除班级
    @Delete("delete from clazz where id=#{id}")
    void deleteById(Integer id);

    //添加班级
    void addClazz(Clazz clazz);

    @Select("select c.id,c.name,c.room,c.begin_date,c.end_date,c.subject,c.create_time,c.update_time from clazz c where id=#{id}")
    Clazz getClazzById(Integer id);

    @Update("update clazz set name=#{name},room=#{room},begin_date=#{beginDate},end_date=#{endDate},master_id=#{masterId},subject=#{subject} where id=#{id}")
    void updateClazz(Clazz clazz);

    @Select("select c.id, name, subject, room, begin_date, end_date, master_id, create_time, status, update_time from clazz c")
    List<Clazz> getClazzList();
}
