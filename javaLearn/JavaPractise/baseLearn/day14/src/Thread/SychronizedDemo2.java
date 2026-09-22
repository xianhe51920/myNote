package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class SychronizedDemo2 {
    /*
        同步方法 在方法返回值类型前面加入sychronized关键字
        public synchronized void method(){}
        方法为静态和非静态
        静态方法的锁对象是字节码对象，非静态方法的锁对象是this
    */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t1 = new Thread(new TicketTask2(),"窗口A");
        Thread t2 = new Thread(new TicketTask2(),"窗口B");
        t1.start();
        t2.start();
    }
}

class TicketTask2 implements Runnable {
    static int ticket = 1000;

    @Override
    public void run() {
        while (true) {
            String name = Thread.currentThread().getName();
            if ("窗口A".equals(name)) {
                if (method1()) {
                    break;
                }
            } else {
                if(method2()){
                    break;
                }
            }
        }
    }

    // 锁对象为class
    private static synchronized boolean method1() {
        if (ticket == 0) return true;
        System.out.println(Thread.currentThread().getName() + "卖出了第" + ticket + "张票");
        ticket--;
        return false;
    }

    // 锁对象为this
    private synchronized boolean method2() {
        if (ticket == 0) return true;
        System.out.println(Thread.currentThread().getName() + "卖出了第" + ticket + "张票");
        ticket--;
        return false;
    }
}