package website.fairycrane.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import website.fairycrane.mapper.StudentMapper;
import website.fairycrane.pojo.PageResult;
import website.fairycrane.pojo.Student;
import website.fairycrane.pojo.StudentOption;
import website.fairycrane.pojo.StudentParam;
import website.fairycrane.service.StudentService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    // 学员列表查询
    @Override
    public PageResult<Student> pageResult(StudentParam studentParam) {
        PageHelper.startPage(studentParam.getPage(),studentParam.getPageSize());
        Page<Student> list = studentMapper.page(studentParam);
        return new PageResult<Student>(list.getTotal(),list.getResult());
    }

    // 根据id删除学员
    @Override
    public void deleteStudentsById(List<Integer> ids) {
        studentMapper.deleteStudentById(ids);
    }

    // 添加学员
    @Override
    public void addStudent(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insertStudent(student);
    }

    // 根据id查询学员
    @Override
    public Student getInfoById(Integer id) {
        return studentMapper.getInfoById(id);
    }

    @Override
    public void updateStudent(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateStudent(student);
    }

    // 违纪处理
    @Override
    public void violate(Integer id, Integer score) {
        studentMapper.violate(id,score);
    }

    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        return studentMapper.getStudentDegreeData();
    }

    @Override
    public StudentOption studentCountData() {
        List<Map<String,Object>> list = studentMapper.studentCountData();
        List<String> clazzList = list.stream().map(item -> item.get("clazz").toString()).toList();
        // count(s.id) 在 MySQL 中是 BIGINT，JDBC 驱动映射为 Long
        List<Long> dataList = list.stream().map(item -> (Long) item.get("data")).toList();
        return new StudentOption(clazzList,dataList);
    }
}
