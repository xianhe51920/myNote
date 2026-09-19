package API;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class UpdateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        System.out.println("当前时间：");
        System.out.println(now);
        //minus 减去
        System.out.println("减去时间：");
        System.out.println("减一年：" + now.minusYears(1));
        System.out.println("减一月：" + now.minusMonths(1));
        System.out.println("减一日：" + now.minusDays(1));
        System.out.println("减一小时：" + now.minusHours(1));
        System.out.println("减一分钟：" + now.minusMinutes(1));
        System.out.println("减一秒：" + now.minusSeconds(1));
        System.out.println("减一纳秒：" + now.minusNanos(1));
        //plus 加上
        System.out.println("加上时间：");
        System.out.println("加上一年：" + now.plusYears(1));
        System.out.println("加上一月：" + now.plusMonths(1));
        System.out.println("加上一日：" + now.plusDays(1));
        System.out.println("加上一小时：" + now.plusHours(1));
        System.out.println("加上一分钟：" + now.plusMinutes(1));
        System.out.println("加上一秒：" + now.plusSeconds(1));
        System.out.println("加上一纳秒：" + now.plusNanos(1));
        // with 设置
        System.out.println("设置年份" + now.withYear(2000));
        System.out.println("设置月份" + now.withMonth(1));
        System.out.println("设置日份" + now.withDayOfMonth(1));
        System.out.println("设置小时" + now.withHour(1));
        System.out.println("设置分钟" + now.withMinute(1));
        System.out.println("设置秒" + now.withSecond(1));
        System.out.println("设置纳秒" + now.withNano(1));
        // isBefore 判断是否在前 isAfter 判断是否在后
        LocalDateTime myDate = LocalDateTime.of(2006,11,23,1,1,1);;
        System.out.println("判断时间：now是否在myDate之前：" + now.isBefore(myDate));
        System.out.println("判断时间：now是否在myDate之后：" + now.isAfter(myDate));
        // equals 判断是否相等
        System.out.println("判断时间：now是否等于myDate：" + now.equals(myDate));
    }
}
