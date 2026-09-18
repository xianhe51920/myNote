package API;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SimpleDateFormatTest {
    /*
    需求：键盘录入用户生日，算出今年多少岁
     */
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的生日");
        String birthday = sc.next();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        //创建date对象接收解析
        Date birthdayDate = sdf.parse(birthday);
        //创建当前时间Date对象
        Date now = new Date();
        //获取当前年龄
        long age = (now.getTime()-birthdayDate.getTime()) / 1000 / 60 / 60 / 24 / 365;
        System.out.println("你今年"+age+"岁");
    }
}
