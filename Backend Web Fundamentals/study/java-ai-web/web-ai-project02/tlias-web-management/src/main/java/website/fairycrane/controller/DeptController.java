package website.fairycrane.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import website.fairycrane.pojo.Dept;
import website.fairycrane.pojo.Result;
import website.fairycrane.service.DeptService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class DeptController {
    // 依赖注入
    private final DeptService deptService;

    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    //    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    // 部门列表查询
    // 限定请求方式
    @GetMapping("/depts")
    public Result list(){
        List<Dept> deptlist = deptService.getAll();
        return Result.success(deptlist);
    }

    // 删除部门
    @DeleteMapping("/depts")
    public Result delete(int id){
        boolean delete = deptService.delete(id);
        if(delete){
            return Result.success();
        }else {
            return Result.error("无效的参数");
        }
    }

    // 添加部门
    @PostMapping("/depts")
    public Result insert(String name) {
        boolean insert = deptService.insert(name);
        if (insert){
            return Result.success();
        }else{
            return Result.error("不能添加已有部门");
        }
    }
}