package Thread;

public class ThreadDemo1 {
    /*
        Java程序默认是多线程的，
        1.main线程
        2.垃圾回收线程
    */
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Demo();
        }
    }
}

class Demo{
    int[] a = new int[100000];
    @Override
    protected void finalize() throws Throwable{
        System.out.println("垃圾被清理了");
    }
}