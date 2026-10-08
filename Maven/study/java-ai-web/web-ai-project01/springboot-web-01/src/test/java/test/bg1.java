package test;
import java.util.Scanner;

/**
 * 实验 2  数字转星期值
 * 从键盘接收整数，1-7 打印对应星期值，否则打印“非法参数”。
 */
public class bg1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // print 函数不会输出换行符，只会输出括号中的内容
        System.out.print("请输入星期值：");
        int week = sc.nextInt();

        switch (week) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期日");
                break;
            default:
                System.out.println("非法参数");
                break;
        }

        sc.close();

        // 生成随机数
        System.out.print("请输入一个数：");
        int num = sc.nextInt();
        int times = 10;
        while (times > 0) {
            int guess = sc.nextInt();
            if (guess == num) {
                System.out.println("恭喜你，猜对了，游戏结束");
                break;
            } else if (guess > num) {
                System.out.println("大了，请再猜一次");
            } else {
                System.out.println("小了，请再猜一次");
            }
            times--;
        }
        System.out.println("你一共猜了：" + (10 - times) + "次，系统生成的随机数是：" + num);

    }
}
