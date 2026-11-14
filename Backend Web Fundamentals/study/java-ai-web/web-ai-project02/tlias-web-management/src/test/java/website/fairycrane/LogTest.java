package website.fairycrane;

import org.junit.jupiter.api.Test;
import website.fairycrane.pojo.Log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogTest {
    private final Log log = new Log();

    @Test
    public void logTest() {
        log.setOperateTime(LocalDateTime.now());
        System.out.println(log.getOperateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
    }
}
