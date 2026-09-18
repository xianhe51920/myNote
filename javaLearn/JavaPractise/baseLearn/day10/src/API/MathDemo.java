package API;

public class MathDemo {
    /*
    Math类：包含执行基本数字运算的方法
    ——————————————————————————————————————————————————
    abs 绝对值
    ceil 向上取整
    floor 向下取整
    round 四舍五入
    max 获取两个int最大值
    pow 返回a的b次幂的值
    random 返回double的随机值[0.0,1.0)
     */
    public static void main(String[] args) {
        System.out.println("绝对值");
        System.out.println(Math.abs(-1));

        System.out.println("向上取整");
        System.out.println(Math.ceil(5.1));

        System.out.println("向下取整");
        System.out.println(Math.floor(5.1));

        System.out.println("四舍五入");
        System.out.println(Math.round(5.5));
        System.out.println(Math.round(4.5));

        System.out.println("最大值");
        System.out.println(Math.max(3, 5));

        System.out.println("幂次方");
        System.out.println(Math.pow(2, 2));

        System.out.println("随机数");
        System.out.println(getRandomInt(1, 3));


    }

    public static int getRandomInt(int m, int n) {
        return (int)(Math.random() * (n - m + 1)) + m;
    }
}
