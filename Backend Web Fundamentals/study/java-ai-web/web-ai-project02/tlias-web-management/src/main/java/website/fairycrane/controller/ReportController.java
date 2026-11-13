package website.fairycrane.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.fairycrane.pojo.JobOption;
import website.fairycrane.pojo.Result;
import website.fairycrane.service.EmpService;
import website.fairycrane.service.ReportService;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {
    @Autowired
    private ReportService reportService;

    // 统计员工职位人数
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计员工职位人数");
        JobOption option = reportService.getEmpJobData();
        log.info("统计结果为，{}",option);
        return Result.success(option);
    }

    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工性别");
            List<Map<String,Object>> genderList= reportService.getEmpGenderData();
            return Result.success(genderList);
        }
    }
