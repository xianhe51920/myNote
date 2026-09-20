package IO;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    /**
     * 七、FileWriter 字符输出流
     * 7.1 构造方法
     * 构造方法	说明
     * FileWriter(String fileName)	字符输出流关联文件，路径以字符串形式给出
     * FileWriter(String fileName, boolean append)	参数 2：追加写入的开关
     * FileWriter(File file)	字符输出流关联文件，路径以 File 对象形式给出
     * FileWriter(File file, boolean append)	参数 2：追加写入的开关
     * 7.2 成员方法
     * 方法	说明
     * public void write(int c)	写出单个字符
     * public void write(char[] cbuf)	写出一个字符数组
     * public void write(char[] cbuf, int off, int len)	写出字符数组的一部分
     * public void write(String str)	写出字符串
     * public void write(String str, int off, int len)	写出字符串的一部分
     * ⚠注意事项：字符输出流写出数据，需要调用 flush 或 close 方法，数据才会写出。
     * flush() 后可以继续写出
     * close() 后不能继续写出（流已关闭）
     */
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("day12/src/IO/text/C.txt");
        // 写出单个字符
        fileWriter.write('喵');
        // 写出一个字符数组
        char[] c = {'\n','世','界','，','由','我','守','护','\n'};
        fileWriter.write(c);
        // 写出字符数组的一部分
        char[] c1 = {'我','喜','欢','锁','瞑','这','里','乱','写','的','\n'};
        fileWriter.write(c1,0,5);
        // 写出字符串
        fileWriter.write("\n再累也要坚持学习\n");
        // 写出字符串的一部分
        fileWriter.write("你怎么想到什么就写什么，我也不知道",0,11);
        // flush写出数据
        fileWriter.flush();
        fileWriter.write("\n我还能写");
        fileWriter.close();
        try {
            fileWriter.write("666");
        }catch (Exception e){
            System.out.println("666，我写不下去了");
        }
    }
}
