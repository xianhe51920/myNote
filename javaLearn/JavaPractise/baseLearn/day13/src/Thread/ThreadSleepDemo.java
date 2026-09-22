package Thread;

public class ThreadSleepDemo {
    /*
    休眠线程的方法

    public static void sleep(long time) 让线程休眠指定时间，单位为毫秒
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThread();
        int i = 5;
        while(i > 0){
            Thread.sleep(1000);
            System.out.println("倒计时" + i + "秒");
            i--;
        }
        System.out.println("结束");
    }
}
