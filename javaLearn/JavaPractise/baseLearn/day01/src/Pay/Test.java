package Pay;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("请选择你的支付方式：1、支付平台支付 2、银行卡网银支付 2、信用卡快捷支付");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        Pay p = switch (choice) {
            case 1 -> new PlatForm();
            case 2 -> new BankCard();
            case 3 -> new CreditCard();
            default -> null;
        };
        System.out.println("请输入你的支付金额：");
        double m = sc.nextDouble();
        if (p != null) {
            p.pay(m);
        }
    }
}

class PlatForm implements Pay{
    @Override
    public void pay(double m) {
        System.out.println("通过支付平台支付" + m + "元");
    }
}

class BankCard implements  Pay {
    @Override
    public void pay(double m) {
        System.out.println("通过银行卡支付" + m + "元");
    }
}

class CreditCard implements Pay{
    @Override
    public void pay(double m) {
        System.out.println("通过信用卡支付" + m + "元");
    }
}
