package API;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDemo {
    /*
    BigDecimal 大十进制数，用于精确小数运算

    创建对象：
    BigDecimal(double val) 不推荐，无法保证小数运算的精确
    BigDecimal(String val)
    BigDecimal valueOf(double val)

    注意：出现除不尽的情况就会产生异常

    常用方法：返回BigDecimal对象
    add 加
    subtract 减
    multiply 乘
    divide 除，有舍入模式

      RoundingMode.HALF_UP 四舍五入
      RoundingMode.UP 进1法
      RoundingMode.DOWN 去尾法
     */
    public static void main(String[] args) {
        BigDecimal bd1 = new BigDecimal("0.1");
        BigDecimal bd2 = BigDecimal.valueOf(0.2);
        System.out.println("加法：");
        System.out.println(bd1.add(bd2));
        System.out.println("减法：");
        System.out.println(bd1.subtract(bd2));
        System.out.println("乘法：");
        System.out.println(bd1.multiply(bd2));
        System.out.println("除法：");
        System.out.println("无舍入模式");
        System.out.println(bd1.divide(bd2));
        System.out.println("有舍入模式");
        System.out.println(bd1.divide(bd2, 5,RoundingMode.HALF_UP));

        // 转换
        System.out.println("转换");
        System.out.println(Math.ceil(bd1.doubleValue()));

    }
}
