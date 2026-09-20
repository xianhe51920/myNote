package Hutool;

import cn.hutool.core.io.IoUtil;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class HutoolDemo {
    /**
     * IoUtil 类提供的部分方法：
     * 方法	说明
     * copy(InputStream in, OutputStream out, int bufferSize)	字节流拷贝
     * copy(Reader reader, Writer writer)	字符流拷贝
     * readLines(Reader reader, Collection<String> collection)	按行读取内容到集合
     * close(Closeable closeables)	安全关闭流
     *
     * FileUtil 类提供的部分方法：
     * touch(filePath)	创建文件（自动创建父目录）
     * mkdir(dirPath)	创建目录（支持多级目录）
     * copy(srcPath, destPath, isOverride)	复制文件或目录（可选覆盖）
     * move(srcFile, destDir, isOverride)	移动文件或目录
     */
    public static void main(String[] args) throws IOException {
        // 创建字符输入输出流
        FileReader fileReader = new FileReader("E:\\myNote\\javaLearn\\JavaPractise\\baseLearn\\day12\\src\\text\\A.txt");
        FileWriter fileWriter = new FileWriter("E:\\myNote\\javaLearn\\JavaPractise\\baseLearn\\day12\\src\\text2\\A.txt");
        // 进行拷贝
        IoUtil.copy(fileReader,fileWriter);
        System.out.println("拷贝结束，关闭流");
        fileReader.close();
        // 重新创建一个输入流，该流为拷贝的对象
        FileReader fileReader1 = new FileReader("E:\\myNote\\javaLearn\\JavaPractise\\baseLearn\\day12\\src\\text2\\A.txt");
        // 创建一个集合接收字符流
        Collection<String> arr = new ArrayList<>();
        // 读取到集合中，打印输出
        IoUtil.readLines(fileReader1,arr);
        for (String s : arr) {
            System.out.println(s);
        }
        // 安全关闭
    }
}
