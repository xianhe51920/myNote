package IO;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    /*
    FileReader：用于读取纯文本文件，解决中文乱码问题
    构造方法：
    1.public FileReader（String fileName）字符输入流关联文件，路径以字符串形式给出
    2.public FileReader（File file）字符输入流关联文件，路径以File对象形式给出
    成员方法：
    pubLic int read（）：读取单个字符
    pubLic int read（char[] cbuf）：读取一个字符数组，返回读取到的有效字符个数*/
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("day12/src/IO/text/B.txt");
        char[] c = new char[1024];
        int len = fileReader.read(c);
        System.out.println(new String(c,0,len));

    }

    private static void method() throws IOException {
        FileReader fileReader = new FileReader("day12/src/IO/text/B.txt");
        int i;
        while((i = fileReader.read()) != -1){
            System.out.print((char) i);
        }
    }
}