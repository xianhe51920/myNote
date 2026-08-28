package String;

import java.util.Scanner;

public class StringTest2 {
    /*
    需求：以字符串的形式从键盘接受一个手机号，将中间四位号码屏蔽
    最终效果为：`156****1234`
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个手机号：");
        String number = sc.next();
        String pNumber = number.substring(0, 3) + "****" + number.substring(7);
        System.out.println(pNumber);
    }
}