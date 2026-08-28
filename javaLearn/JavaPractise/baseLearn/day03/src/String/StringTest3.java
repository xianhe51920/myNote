package String;

import java.util.Scanner;

public class StringTest3 {
    /*
    需求：键盘录入一个字符串，如果字符串中包含 `(TMD)`，则使用 `***` 替换
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next().replace("TMD","***");
        System.out.println(s);

        /*
        字符串切割
         */
        String[] s1 = "192.168.1.0".split("\\.");
        System.out.println(s1[0]);

    }
}
