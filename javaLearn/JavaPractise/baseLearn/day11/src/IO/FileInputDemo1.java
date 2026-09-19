package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class FileInputDemo1 {
    /*
        FileInputStream字节输入流读取数据
        1．构造方法：
        FileInputStream(String name)输入流关联文件，文件路径以字符串形式给出
        FileInputStream(File file)输入流关联文件，文件路径以FiLe对象形式给出
        2.成员方法：
        public int read()读取单个字节
        public int read(byte[] bys)读取一个字节数组
        －将读取到的字节，存入数组容器，返回读取到的有效字节个数，到达文件结尾返回-1
    */
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("day11/src/IO/text/A.txt");
        int len;
        byte[] bys = new byte[2];
        while((len = fis.read(bys)) != -1){
            // new String(字节数组，起始下标，截取长度)
            String s = new String(bys,0,len);
            System.out.print(s);
        }

    }

    private static void method2() throws IOException {
        FileInputStream fis = new FileInputStream("day11/src/IO/text/A.txt");
        byte[] bys = new byte[2];
        int len1 = fis.read(bys);
        System.out.println(Arrays.toString(bys));
        System.out.println("有效字节数" + len1);
        int len2 = fis.read(bys);
        System.out.println(Arrays.toString(bys));
        System.out.println("有效字节数" + len2);
        int len3 = fis.read(bys);
        System.out.println(Arrays.toString(bys));
        System.out.println("有效字节数" + len3);
    }

    private static void method() throws IOException {
        FileInputStream fis = new FileInputStream("day11/src/IO/text/A.txt");
        int i;
        while ((i = fis.read()) != -1) {
            System.out.print((char) i);
        }
    }
}
