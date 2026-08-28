package String;

import java.util.Scanner;

public class Stringtest {
    /*
    需求：已知正确的用户名和密码，请用程序实现模拟用户登录，
    总共三次机会，登录之后，给出相应提示
     */
    public static void main(String[] args) {
        String uname = "admin";
        String password = "666";
        int cot = 3;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.print("请输入用户名：");
            String scName = sc.next();
            System.out.print("请输入密码：");
            String scPassword = sc.next();
            if (uname.equals(scName) && password.equals(scPassword)) {
                break;
            } else {
                cot--;
                System.out.println("用户名或密码错误，还有" + cot + "次机会");
            }
        }

        if (cot == 0) {
            System.out.println("连续三次输入错误，账号已锁定");
        } else {
            System.out.println("登录成功");
        }
    }
}
