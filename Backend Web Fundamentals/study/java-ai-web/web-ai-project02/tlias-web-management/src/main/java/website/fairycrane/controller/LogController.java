package website.fairycrane.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.fairycrane.mapper.LogMapper;
import website.fairycrane.pojo.Log;
import website.fairycrane.pojo.PageResult;
import website.fairycrane.pojo.Result;
import website.fairycrane.service.LogService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {
    private final LogService logService;

    public LogController(LogMapper logMapper, LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/page")
    public Result page(Integer page, Integer pageSize){
        PageResult<Log> logPageResult = logService.page(page,pageSize);
        return Result.success(logPageResult);
    }
}
