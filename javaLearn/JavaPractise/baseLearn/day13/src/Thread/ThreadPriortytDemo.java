package Thread;

public class ThreadPriortytDemo {
    /*
    线程调度分为抢占式和非抢占式调度，java是前者
        线程优先级默认为5(概率)
        setPriority(int newPriority)设置线程的优先级
        final int getPriority()获取线程的优先级
        final void setDaemon(boolean on)设置为守护线程
    */
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500; i++) {
                    System.out.println(Thread.currentThread().getName() + i + "次");
                }
            }
        }, "线程A");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500; i++) {
                    System.out.println(Thread.currentThread().getName() + i + "次");
                }
            }
        }, "线程B");
        // 设置优先级
        t1.setPriority(10);
        t2.setPriority(1);
        // 运行
        t1.start();
        t2.start();
    }
}
