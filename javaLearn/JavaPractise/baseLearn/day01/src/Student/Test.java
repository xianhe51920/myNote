package Student;

public class Test {
    public static void main(String[] args) {
        Student st = new Student();
        Student st1 = new Student();
        System.out.println(st);
        System.out.println(st1);

    }
}
class Student {
    public Student() {
        System.out.println("构造方法");
    }

    {
        System.out.println("构造代码块");     // 每次 new 都执行
    }

    static {
        System.out.println("静态代码块");     // 加载类时执行
    }
}
