package website.fairycrane.controller;

import cn.hutool.core.io.IoUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.fairycrane.pojo.User;
import website.fairycrane.service.UserService;
import website.fairycrane.service.impl.UserServiceImpl;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        // 1. 加载并读取txt文件，获取用户数据

        // 2. 解析用户信息，封装为User对象
        // 3. 返回json的数据
        return userService.getUsersData();
    }
}