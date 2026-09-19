package API;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterDemo {
    /*
    DateTimeFormatter类，用于时间的格式化和解析
    ofPattern 获取格式对象
    format 按照指定方式格式化

    解析
    LocalDate.parse(字符串,格式化对象)
    LocalTime.parse(字符串,格式化对象)
    LocalDateTime.parse(字符串,格式化对象)
     */
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间" + now);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        System.out.println("格式化时间" + dtf.format(now));

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.parse("2020/11/23 11:34:00",dtf1);
        System.out.println(time);
    }
}
