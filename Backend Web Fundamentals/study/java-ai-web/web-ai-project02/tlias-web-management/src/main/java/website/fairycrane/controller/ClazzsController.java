package website.fairycrane.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import website.fairycrane.pojo.Clazz;
import website.fairycrane.pojo.ClazzQueryParam;
import website.fairycrane.pojo.PageResult;
import website.fairycrane.pojo.Result;
import website.fairycrane.service.ClazzService;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzsController {
    @Autowired
    private ClazzService clazzService;
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam){
        log.info("收到前端的get请求，{}",clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.pageResult(clazzQueryParam);
        return Result.success(pageResult);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        log.info("接收到的参数，{}",id);
        clazzService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result addClazz(@RequestBody Clazz clazz){
        clazzService.addClazz(clazz);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getClazzById(@PathVariable Integer id){
        Clazz clazz = clazzService.getClazzById(id);
        return Result.success(clazz);
    }

    @PutMapping
    public Result updateClazz(@RequestBody Clazz clazz){
        clazzService.updateClazz(clazz);
        return Result.success();
    }

    // 查询所有班级
    @GetMapping("/list")
    public Result list(){
        return Result.success(clazzService.getClszzList());
    }
}
