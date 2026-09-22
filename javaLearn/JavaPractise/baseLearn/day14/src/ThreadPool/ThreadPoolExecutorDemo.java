package ThreadPool;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {
    /*
        ThreadPoolExecutor(int corePoolsize, int maximumPoolsize, long keepAliveTime, TimeUnit unit,
        BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler)
        参数1 核心线程数量(正式员工)
        参数2 最大线程数量(正式员工 +临时工)
        参数3 空闲时间
        参数4 时间单位
        参数5 任务队列(指定排队人数）
        参数6 线程对象工厂（负责创建线程对象）
        参数7 拒绝策略
    */
    public static void main(String[] args) {

        try (ThreadPoolExecutor pool = new ThreadPoolExecutor(
                1,
                4,
                1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(10), // new LinkedBlockingQueue<>(), //
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        )){

            for (int i = 0; i < 100; i++) {
                pool.submit(() -> System.out.println(Thread.currentThread().getName() + "提交了线程任务"));
            }
        }
    }
}
