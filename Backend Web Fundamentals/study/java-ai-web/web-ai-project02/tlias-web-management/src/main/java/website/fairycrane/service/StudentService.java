package website.fairycrane.service;

import website.fairycrane.pojo.PageResult;
import website.fairycrane.pojo.Student;
import website.fairycrane.pojo.StudentOption;
import website.fairycrane.pojo.StudentParam;

import java.util.List;
import java.util.Map;

public interface StudentService {
    PageResult<Student> pageResult(StudentParam studentParam);

    void deleteStudentsById(List<Integer> ids);

    // 添加学员
    void addStudent(Student student);

    Student getInfoById(Integer id);

    void updateStudent(Student student);

    // 违纪处理
    void violate(Integer id, Integer score);

    // 学员学历统计
    List<Map<String, Object>> getStudentDegreeData();

    StudentOption studentCountData();
}
