package lomboktest;


import java.util.Objects;

public class LombokDemo {
    /**
     * 测试lombok的效果
     */
    public static void main(String[] args) {
        // 验证构造方法
        System.out.println("验证构造方法");
        Student stu = new Student();
        stu.setName("仙鹤");
        stu.setAge(18);
        Student stu1 = new Student("锁暝",16);
        // 验证toString方法
        System.out.println("验证toString方法");
        System.out.println(stu + "\n" + stu1);
        // 验证equals方法
        System.out.println("验证equals方法");
        System.out.println(Objects.equals(stu,stu1));
    }
}
