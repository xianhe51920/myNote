package website.fairycrane.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import website.fairycrane.pojo.Dept;
import website.fairycrane.pojo.Result;
import website.fairycrane.service.DeptService;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/depts") // 抽取路径公共部分
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
    @GetMapping
    public Result list() {
        List<Dept> deptlist = deptService.getAll();
        return Result.success(deptlist);
    }

    // 删除部门
    // @DeleteMapping("/depts")
    // 方式一：通过HttpServletRequest获取请求参数 （不推荐）
    // public Result delete(HttpServletRequest request){
    //     String id = request.getParameter("id");
    //     int deptId = Integer.parseInt(id);
    //     System.out.println("根据id删除部门" + id);
    //     return Result.success();
    // }

    // 方式二：@RequestParam
    // 注意事项：一旦声明了@RequestParam，该参数在请求时必须传递，如果不传递将会报错。（默认required为true）
    // @DeleteMapping("/depts")
    // public Result delete(@RequestParam(value = "id",required = false) Integer id){
    //     System.out.println("根据id删除部门" + id);
    //     return Result.success();
    // }

    // 方式三：如果请求参数名与形参变量名相同，直接定义方法形参即可接收。（省略@RequestParam）推荐
    @DeleteMapping
    public Result delete(Integer id) {
        deptService.deleteById(id);
        return Result.success();
    }

    // 添加部门
    // JSON格式的参数，通常会使用一个实体对象进行接收
    // 规则：JSON数据的键名与方法形参对象的属性名相同，并需要使用@RequestBody注解标识。
    @PostMapping
    public Result insert(@RequestBody Dept dept) {
        deptService.add(dept);
        return Result.success();
    }

    // 根据id查询部门
    // 路径参数：通过请求URL直接传递参数，使用{...}来标识该路径参数，需要使用@PathVariable绑定参数
    // @GetMapping("/depts/{id}")
    // public Result getInfo(@PathVariable("id") Integer deptId){
    //     System.out.println("根据id查询部门" + deptId);
    //     return Result.success();
    // }

    // 形参名和路径参数名一致可省略@PathVariable的参数
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        Dept dept = deptService.getInfo(id);
        return Result.success(dept);
    }

    // 根据id修改部门
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        deptService.update(dept);
        return Result.success();
    }
}