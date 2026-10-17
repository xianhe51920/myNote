package website.fairycrane.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.fairycrane.pojo.User;
import website.fairycrane.service.UserService;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class UserController {
//    @Autowired // 依赖注入
//    @Qualifier("userServiceImpl2") // 指定要注入的Bean的名字
//    private UserService userService;

    // 第三种解决方案，相当于把上面的注解合并了
    @Resource(name = "userServiceImpl2")
    private UserService userService;


    @RequestMapping("/list")
    public List<User> list() throws FileNotFoundException {
        // 返回json的数据
        return userService.getUsersData();
    }
}