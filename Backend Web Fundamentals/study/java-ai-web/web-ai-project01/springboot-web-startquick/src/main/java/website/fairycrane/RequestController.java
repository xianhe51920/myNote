package website.fairycrane;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class RequestController {
    @RequestMapping("/request")
    public String request(HttpServletRequest request){
        // 1. 获取请求方式
        String method = request.getMethod();
        System.out.println("请求方式：" + method);
        // 2. 获取请求url地址
        String url = request.getRequestURL().toString();
        String uri = request.getRequestURI();
        System.out.println("请求URL：" + url + "\n" + "请求URI：" + uri);
        // 3. 获取请求协议
        String protocol = request.getProtocol();
        System.out.println("请求协议：" + protocol);

        // 4. 获取请求参数
        String parameterName = request.getParameter("name");
        String parameterAge = request.getParameter("age");
        System.out.println("请求参数：\n" + "姓名" + parameterName + "\n" + "年龄" + parameterAge);

        // 5. 获取请求头
        String accept = request.getHeader("Accept-Language");
        System.out.println("请求头：" + accept);

        // 6. 获取请求体
        String requestBody;
        try {
            requestBody = request.getReader().lines().reduce("", String::concat);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("请求体：" + requestBody);
        return "请求成功";
    }
}
