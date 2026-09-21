public class ThreadDaemonDemo {
    // final void setDaemon(boolean on)设置为守护线程
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "线程执行了" + i);
                }
            }
        }, "线程A");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500; i++) {
                    System.out.println(Thread.currentThread().getName() + "线程执行了" + i);
                }
            }
        }, "线程B");
        // 设置守护线程
        t2.setDaemon(true);
        // 执行
        t1.start();
        t2.start();
        // 线程A结束后，线程2也会挂掉，不会执行结束
    }
}
