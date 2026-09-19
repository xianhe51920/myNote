package IO;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputDemo2 {
    /*
    IO流的异常处理方式：jdk7之前，非常麻烦，了解一下就行
     */
    public static void main(String[] args) {
        System.out.println("开始");
        // 在外部声明，引入作用域
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("day11/src/IO/text/A.txt");
            fos.write("12341234".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("关闭文件");
        }

        System.out.println("结束");
    }
}
