package IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo2 {
    /**
     * 和 IO 有关的方法
     * void load(InputStream inStream)	从输入字节流读取属性列表（键和元素对）
     * void load(Reader reader)	从输入字符流读取属性列表（键和元素对）
     * void store(OutputStream out, String comments)	将此属性列表写入输出字节流，以适合 load(InputStream) 方法的格式
     * void store(Writer writer, String comments)	将此属性列表写入输出字符流，以适合 load(Reader) 方法的格式
     */
    public static void main(String[] args) throws IOException {
        // 创建一个有键值对的Properties
        Properties properties = new Properties();
        properties.setProperty("仙鹤","19岁");
        properties.setProperty("锁暝","16岁");
        properties.setProperty("莫宁","21岁");
        properties.setProperty("清宵","1000岁");
        // 创建一个字符输出流
        FileWriter fileWriter = new FileWriter("E:\\myNote\\javaLearn\\JavaPractise\\baseLearn\\day12\\src\\IO\\text\\D.txt");
        properties.store(fileWriter,"this is a description");
        fileWriter.close();
        // 创建一个字符输入流
        FileReader fileReader = new FileReader("E:\\myNote\\javaLearn\\JavaPractise\\baseLearn\\day12\\src\\IO\\text\\D.txt");
        // 创建一个新的Properties对象
        Properties properties1 = new Properties();
        // 加载键值对
        properties1.load(fileReader);
        // 获取所有键
        Set<String> keys = properties1.stringPropertyNames();
        keys.forEach(k -> System.out.println(k + ":" + properties1.get(k)));
    }
}
