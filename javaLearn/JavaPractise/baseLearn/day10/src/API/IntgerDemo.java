package API;

public class IntgerDemo {
    /*
    Integer类常见方法：
    toBinaryString 得到二进制
    toOctalString 得到八进制
    toHexString 得到十六进制
    parseInt 将字符串类型的整数转成int类型的整数
     */
    public static void main(String[] args) {
        int a = 100;
        System.out.println("以int a = 100 为例：");
        System.out.println("二进制 " + Integer.toBinaryString(a));
        System.out.println("八进制 " + Integer.toOctalString(a));
        System.out.println("十六进制 " + Integer.toHexString(a));
        System.out.println("字符串100转int " + Integer.parseInt("100"));
        // 所有包装类中，只有Character和String没有parse方法
    }
}
