package StringB;

import java.util.Objects;
import java.util.Scanner;

public class Palindrome {
    /*
    需求：键盘接受一个字符串，程序判断出该字符串是否是对称字符串，并在控制台打印是或不是
    对称字符串：`123321`、`111`
    非对称字符串：`123123`
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        StringBuilder s = new StringBuilder(sc.next());
        System.out.println(s +"____"+ s.reverse());
        if (Objects.equals(s.toString(),s.reverse().toString())){
            System.out.println("这是回文字符串");
        } else {
            System.out.println("这不是回文字符串");
        }
    }
}
