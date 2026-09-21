public class ThreadNameDemo4 {
    /*
    Thread相关方法
    String getName()返回此线程的名称
    void setName(String name)设置线程的名字（构造方法也可以设置名字）
    static Thread currentThread()获取当前线程的对象
    */
    public static void main(String[] args) {
        Thread mt1 = new MyThread();
        mt1.setName("mt1Name");
        Thread mt2 = new MyThread("mt2Name");
        System.out.println(mt1.getName());
        System.out.println(mt2.getName());
    }
}
