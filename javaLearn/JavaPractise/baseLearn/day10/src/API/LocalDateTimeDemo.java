package API;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;

public class LocalDateTimeDemo {
    /*
    LocalDate,LocalTime,LocalDateTime

    对象创建方式
    1. now 当前时间
    2. of 设置时间
     */
    public static void main(String[] args) {
        show();
    }

    private static void show() {
        // 日期，时间
        LocalDateTime now = LocalDateTime.now();
        // 年
        int year = now.getYear();
        // 月
        Month month = now.getMonth();
        int value = month.getValue();
        int monthValue = now.getMonthValue();
        // 日
        int dayOfMonth = now.getDayOfMonth();
        // 星期
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        int week = dayOfWeek.getValue();
        // 时
        int hour = now.getHour();
        // 分
        int minute = now.getMinute();
        // 秒
        int second = now.getSecond();
        // 纳秒
        int nano = now.getNano();
    }

    private static void method() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间");
        System.out.println(now);
        LocalDateTime localDateTime = LocalDateTime.of(2025,11,23,11,11,12,0);
        System.out.println("指定时间");
        System.out.println(localDateTime);
    }
}
