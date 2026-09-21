import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo3 {
    /*
        开启线程的第三种方式－实现Callable接口
        1．编写一个类实现CalLabLe接口
        2．重写calL方法 （此方法存在返回值)I
        3．将线程任务代码写在call方法中
        4.创建线程资源对象
        5.创建线程任务对象，封装线程资源
        6.创建线程对象，传入线程任务
        7.使用线程对象调用start开启线程
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 第三种方式执行完任务有结果
        // 创建线程资源对象
        MyCall myRunnable = new MyCall();
        // 创建线程任务对象
        FutureTask<String> futureTask1 = new FutureTask<>(myRunnable);
        FutureTask<String> futureTask2 = new FutureTask<>(myRunnable);
        Thread thread1 = new Thread(futureTask1);
        Thread thread2 = new Thread(futureTask2);
        thread1.start();
        thread2.start();
        // 获取结果，线程跑起来再调用
        System.out.println("futureTask1返回的结果是：\n" + futureTask1.get());
        System.out.println("futureTask2返回的结果是：\n" + futureTask2.get());
    }
}

// 结果是什么类型泛型就写什么类型
class MyCall implements Callable<String>{
    @Override
    public String call() throws Exception {
        return "我喜欢你，和我在一起吧";
    }
}