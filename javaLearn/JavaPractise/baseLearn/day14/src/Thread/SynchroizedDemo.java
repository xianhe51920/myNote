package Thread;

public class SynchroizedDemo {
    /*
    同步代码块
    synchroized(任意锁对象){
        goto;
    }
     */
    public static void main(String[] args) {
        TicketTask ticketTask1 = new TicketTask();
        Thread thread1 = new Thread(ticketTask1, "窗口A");
        TicketTask ticketTask2 = new TicketTask();
        Thread thread2 = new Thread(ticketTask1, "窗口B");
        TicketTask ticketTask3 = new TicketTask();
        Thread thread3 = new Thread(ticketTask1, "窗口C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class TicketTask implements Runnable {
    int ticket = 1000;

    @Override
    public void run() {
        while (ticket > 0) {
            // 使用字节码对象，保证锁对象相同
            synchronized (TicketTask.class) {
                if (ticket <= 0) {
                    break;
                }
                ticket--;
                System.out.println(Thread.currentThread().getName() + "卖出了票，还剩" + ticket + "张");
            }
        }
        System.out.println("票卖光了");

    }
}
