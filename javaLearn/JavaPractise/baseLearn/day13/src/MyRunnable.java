class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("我是run方法里面的线程" + i);
            System.out.println("我的线程名称是" + Thread.currentThread().getName());
        }
    }
}
