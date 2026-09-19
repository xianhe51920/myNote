package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputDemo3 {
    /*
        I0流的异常处理方式：jdk7版本开始
        try
        （需要调用close方法的流对象）
        {
            I0流逻辑代码
        }
        catch（异常类名对象名）{
            异常处理方案
        }
        ()中的流对象，会自动调用cLose方法，就算有异常，也会调用cLose，
    */
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("day11/src/IO/text/A.txt")) {
            fos.write("111".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // ()里的内容不是谁都能写的，一定要实现AutoCloseable接口
        try(Demo d = new Demo()){
            System.out.println("try运行");
            System.out.println(10 / 0);
        } catch (NullPointerException e) {
            System.out.println("catch运行");
            throw new RuntimeException(e);
        }

    }
    public static class Demo implements AutoCloseable{

        @Override
        public void close() throws NullPointerException {
            System.out.println("我已关闭");
        }
    }
}
