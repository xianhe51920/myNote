package reflection;

import pojo.Student;

import java.lang.reflect.Field;

public class ReflectionDemo3 {
    /*
    反射类中的成员变量

    1.Field[] getFields() 返回所有公共成员变量对象的数组
    2.Field[] getDeclaredFields() 返回所有成员变量对象的数组
    3.Field getField(String name) 返回单个公共成员变量对象
    4.Field getDeclaredField(String name) 返回单个成员变量对象

    --------------------------------
    Field类的设置和获取方法
    1. void set(Object obj, Object value) 赋值
    2. Object get(Object obj) 获取值
     */
    public static void main(String[] args) throws Exception{
        Class<Student> studentClass = Student.class;
        // 反射类的空参构造方法创建对象
        Student student1 = studentClass.getConstructor().newInstance();
        Student student2 = studentClass.getConstructor().newInstance();
        // 获取成员变量对象
        Field name = studentClass.getDeclaredField("name");
        name.setAccessible(true);
        Field age = studentClass.getDeclaredField("age");
        age.setAccessible(true);
        // 通过成员变量对象赋值
        name.set(student1,"fairy");
        name.set(student2,"crane");

        age.set(student1,18);
        age.set(student2,19);

        // 获取值
        System.out.println(name.get(student1));
        System.out.println(age.get(student1));

        System.out.println(name.get(student2));
        System.out.println(age.get(student2));

    }
}
