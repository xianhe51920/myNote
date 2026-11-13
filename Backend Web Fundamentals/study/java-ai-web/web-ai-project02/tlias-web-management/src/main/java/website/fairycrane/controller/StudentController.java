package website.fairycrane.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import website.fairycrane.pojo.PageResult;
import website.fairycrane.pojo.Result;
import website.fairycrane.pojo.Student;
import website.fairycrane.pojo.StudentParam;
import website.fairycrane.service.StudentService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    // 查询学员列表
    @GetMapping
    public Result page(StudentParam studentParam){
        PageResult<Student> pageResult = studentService.pageResult(studentParam);
        return Result.success(pageResult);
    }

    // 批量删除学员
    @DeleteMapping("/{ids}")
    public Result deleteStudents(@PathVariable List<Integer> ids){
        studentService.deleteStudentsById(ids);
        return Result.success();
    }

    // 添加学员
    @PostMapping
    public Result addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return Result.success();
    }

    // 修改学员
    @PutMapping
    public Result updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return Result.success();
    }

    // 根据id查询（查询回显）
    @GetMapping("/{id}")
    public Result getInfoById(@PathVariable Integer id){
        Student student = studentService.getInfoById(id);
        return Result.success(student);
    }

    // 违纪处理
    @PutMapping("/violation/{id}/{score}")
    public Result violate(@PathVariable Integer id,@PathVariable Integer score){
        studentService.violate(id,score);
        return Result.success();
    }
}
