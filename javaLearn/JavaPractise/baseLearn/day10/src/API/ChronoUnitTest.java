package API;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ChronoUnitTest {
    /*
    键盘录入用户生日，使用ChrnoUnit计算用户多少岁
     */
    public static void main(String[] args) {
        // 获取当前时间对象
        LocalDate now = LocalDate.now();
        // 获取格式化对象
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        // 获取用户生日
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你的生日：");
        String birthDay = sc.next();
        // 解析为时间对象
        LocalDate birthDate = LocalDate.parse(birthDay, dtf);
        // 计算年龄
        long age = ChronoUnit.YEARS.between(birthDate,now);
        System.out.println("你今年" + age + "岁");
    }
}
