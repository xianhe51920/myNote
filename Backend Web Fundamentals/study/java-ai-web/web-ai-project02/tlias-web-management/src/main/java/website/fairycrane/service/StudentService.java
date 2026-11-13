package website.fairycrane.service;

import website.fairycrane.pojo.PageResult;
import website.fairycrane.pojo.Student;
import website.fairycrane.pojo.StudentParam;

import java.util.List;

public interface StudentService {
    PageResult<Student> pageResult(StudentParam studentParam);

    void deleteStudentsById(List<Integer> ids);

    // 添加学员
    void addStudent(Student student);

    Student getInfoById(Integer id);

    void updateStudent(Student student);

    // 违纪处理
    void violate(Integer id, Integer score);
}
