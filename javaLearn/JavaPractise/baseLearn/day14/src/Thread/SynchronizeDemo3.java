package Thread;

import java.util.concurrent.locks.ReentrantLock;

public class SynchronizeDemo3 {
    /*
    使用 Lock 锁，我们可以更清晰地看到哪里加了锁，哪里释放了锁。相比 synchronized，Lock 锁更灵活、性能更好。
    lock() 加锁
    unlock() 释放锁
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(new TicketTask3());
        Thread t2 = new Thread(new TicketTask3());
        t1.start();
        t2.start();
    }
}

class TicketTask3 implements Runnable {
    int tickets = 1000;
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (tickets == 0) {
                lock.lock();
                break;
            }
            System.out.println(Thread.currentThread().getName() + "卖出了第" + tickets + "号票");
            tickets--;
            lock.unlock();
        }
    }
}