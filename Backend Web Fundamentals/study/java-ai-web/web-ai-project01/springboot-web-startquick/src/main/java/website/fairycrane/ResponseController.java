package website.fairycrane;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
        // 1. 设置响应状态码
        response.setStatus(200);
        // 2. 设置响应头
        response.setHeader("name", "fairycrane");

        // 3. 设置相应体
        response.getWriter().write("This is a response from ResponseController");
    }

    @RequestMapping("/response2")
    public ResponseEntity<String> response2() {
        return ResponseEntity.status(200) // 设置响应状态码
                .header("name", "fairycrane") // 设置响应头
                .body("This is a response from ResponseController"); // 设置响应体
    }
}
