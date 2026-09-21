public class ThreadDemo {
    /*
        开启线程的第一种方式－继承Thread类
        1.编写一个类继承Thread类
        2.重写run方法
        3.将线程任务代码写在run方法中
        4.创建线程对象
        5.调用start方法开启线程

        注意事项：调用start方法时会自动调用run()方法
    */
    public static void main(String[] args) {
        // 创建线程对象
        Thread thread = new MyThread();
        thread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("我是主程序的第" + i + "句");
        }

    }
}

