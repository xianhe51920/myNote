package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOtest1 {
    /*
    要求：将文件1拷贝到另一个位置
     */
    public static void main(String[] args){
        try (
            // 创建输入流对象
            FileInputStream fis = new FileInputStream("day11/src/IO/text/A.txt");
            // 创建输出流对象
            FileOutputStream fos = new FileOutputStream("day11/src/IO/text2/A.txt");
        )
        {
            // 拷贝
            int len;
            byte[] bys = new byte[1024];
            while ((len = fis.read(bys)) != -1) {
                // String s = new String(bys,0,len);
                // fos.write(s.getBytes());
                fos.write(bys, 0, len);
            }
            System.out.println("拷贝完成");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
