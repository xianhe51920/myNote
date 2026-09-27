package anno;

public class JDKAnnoDemo {
    /*
    JDK中常见注解
    @Override 表示方法的重写
    @Deprecated 表示修饰的方法已过时
    @SuppressWarnings("all") 压制警告
     */
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        @SuppressWarnings("all")
        int c = a > b ? a : b;
        method();
    }

    @Deprecated
    private static void method(){
        System.out.println("我已过时");
    }
}
