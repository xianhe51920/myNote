package website.fairycrane;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(String name, int age) {
        return "Hello, " + name + "! You are " + age + " years old.";
    }
}
