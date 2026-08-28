package String;

import java.util.Scanner;

public class StringTest1 {
    /*
    需求：键盘录入一个字符串，统计该字符串中大写字母字符、小写字母字符、数字字符出现的次数（不考虑其他字符）
    例如：`aAb3&c2B*4CD1` → 小写：3 个；大写：4 个；数字：4 个
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请录入一个字符串：");
        String s = sc.next();
        int l = 0, u = 0, n = 0;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if ('a' <= tmp && tmp <= 'z') l++;
            else if ('A' <= tmp && tmp <= 'Z') u++;
            else if ('0' <= tmp && tmp <= '9') n++;
        }
        System.out.println("小写：" + l + "个；大写：" + u + " 个；数字：" + n + " 个");
    }
}
