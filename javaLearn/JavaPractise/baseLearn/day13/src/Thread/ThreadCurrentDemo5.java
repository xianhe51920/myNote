package Thread;

public class ThreadCurrentDemo5 {
    /*
    static Thread currentThread()获取当前线程的对象
     */
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable,"线程A");
        thread.start();
        System.out.println("当前线程对象名称" + Thread.currentThread().getName());
    }
}
