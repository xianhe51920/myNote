package API;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ChronoUnitDemo {
    public static void main(String[] args) {
        // 本地时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间：" + now);

        // 生日
        LocalDateTime birthDate = LocalDateTime.of(2006,11,23,0,0,0);
        System.out.println("生日：" + birthDate);

        System.out.println("相差的年数：" + ChronoUnit.YEARS.between(birthDate, now));
        System.out.println("相差的月数：" + ChronoUnit.MONTHS.between(birthDate, now));
        System.out.println("相差的天数：" + ChronoUnit.DAYS.between(birthDate, now));
        System.out.println("相差的小时数：" + ChronoUnit.HOURS.between(birthDate, now));
        System.out.println("相差的分钟数：" + ChronoUnit.MINUTES.between(birthDate, now));
        System.out.println("相差的秒数：" + ChronoUnit.SECONDS.between(birthDate, now));
        System.out.println("相差的毫秒数：" + ChronoUnit.MICROS.between(birthDate, now));
        System.out.println("相差的纳秒数：" + ChronoUnit.NANOS.between(birthDate, now));

    }
}
