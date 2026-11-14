package website.fairycrane.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import website.fairycrane.pojo.Student;
import website.fairycrane.pojo.StudentParam;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    // 学员列表查询
    Page<Student> page(StudentParam studentParam);

    void deleteStudentById(@Param("ids") List<Integer> ids);

    void insertStudent(Student student);

    @Select("select s.id, name, no, gender, phone, degree, id_card, is_college, address, graduation_date, violation_count, violation_score, clazz_id, create_time, update_time from student s where s.id=#{id};")
    Student getInfoById(Integer id);

    void updateStudent(Student student);

    @Update("update student set violation_score=#{score} where id=#{id}")
    void violate(Integer id, Integer score);

    List<Map<String, Object>> getStudentDegreeData();

    List<Map<String, Object>> studentCountData();
}
