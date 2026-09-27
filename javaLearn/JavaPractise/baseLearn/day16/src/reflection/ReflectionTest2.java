package reflection;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionTest2 {
    public static void main(String[] args) throws Exception{
        // 读取配置文件
        FileReader reader = new FileReader("day16\\src\\reflection\\properties.txt");
        Properties properties = new Properties();
        properties.load(reader);
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        reader.close();
        // 获取字节码对象
        Class<?> aClass = Class.forName(className);
        // 创建实例对象
        Object o = aClass.getConstructor().newInstance();
        // 反射类的成员方法对象
        Method method = aClass.getMethod(methodName);
        // 执行
        method.invoke(o);
    }
}

class Student{
    private String name;
    private int age;

    public Student(){}

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void study(){
        System.out.println("学生在学习");
    }
}

class Teacher {
    private String name;
    private int age;

    public Teacher(){}

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void teach(){
        System.out.println("老师在工作");
    }
}

class Worker {
    private String name;
    private int age;

    public Worker(){}

    public Worker(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void work(){
        System.out.println("工人在装修");
    }
}