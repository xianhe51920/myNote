package Thread;

public class ThreadDemo2 {
    /*
    开启线程第二种方式－实现RunnabLe接口
    1.编写一个类实现RunnabLe接口
    2.重写run方法
    3.将线程任务代码，写在run方法中
    4.创建Runnable接口的实现类对象
    5.创建线程对象，并将RunnabLe接口的实现类对象传入
    6.使用线程对象调用start方法开启线程
    */
    public static void main(String[] args) {
        // 实现接口可以多实现，更灵活
        Thread runnable = new Thread(new MyRunnable());
        Thread runnable2 = new Thread(new MyRunnable());
        runnable.start();
        runnable2.start();
        for (int i = 0; i < 500; i++) {
            System.out.println("我是main方法里的线程" + i);
        }
    }
}

