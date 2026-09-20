package IO;

import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
    /**
     * roperties 是 java.util 包下的类，继承自 Hashtable<Object, Object>
     *     本质是一个 Map 集合，但键和值都必须是 String。
     * 作为集合使用
     * 构造	Properties()	创建一个没有默认值的空属性列表
     * 成员方法	Object setProperty(String key, String value)	添加 / 修改一个键值对
     * 成员方法	String getProperty(String key)	根据键获取值
     * 成员方法	Set<String> stringPropertyNames()	获取集合中所有的键
     */
    public static void main(String[] args) {
        Properties properties = new Properties();
        // 添加/修改 键值对
        properties.setProperty("仙鹤","19岁");
        properties.setProperty("锁暝","16岁");
        properties.setProperty("莫宁","21岁");
        properties.setProperty("清宵","1000岁");
        // 根据键获取值
        System.out.println("仙鹤：" + properties.get("仙鹤"));
        System.out.println("锁暝：" + properties.get("锁暝"));
        System.out.println("清宵：" + properties.get("清宵"));
        // 获取集合中所有的键
        Set<String> set = properties.stringPropertyNames();
        System.out.println(set);

    }
}
