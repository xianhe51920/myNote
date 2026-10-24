package website.fairycrane.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import website.fairycrane.pojo.*;
import website.fairycrane.service.EmpService;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    // empMapper
    private final EmpService empService;

    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    // 查询员工信息
    @GetMapping
    /* /emps?name=张&gender=1&begin=2007-09-01&end=2022-09
            01&page=1&pageSize=10 */
    public Result page(EmpQueryParam empQueryParam) {
        PageResult<Emp> pageResult = empService.pageResult(empQueryParam);
        return Result.success(pageResult);
    }

    // 保存员工信息
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        // 保存员工工作信息
        log.info("保存员工工作信息: {}", emp);
        empService.save(emp);
        return Result.success();
    }
}
