package reflection;

import pojo.Student;

import java.lang.reflect.Constructor;

public class ReflectionDemo2 {
    /*
    反射类中的构造方法

    1. Constructor<?>[] getConstructors() 返回所有公共构造方法对象的数据
    2. Constructor<?>[] getDeclaredConstructs() 返回所有构造方法对象的数组
    3. Constructor<T> getConstructor(Class<?>... parameterTypes) 返回单个公共构造方法对象
    4. Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) 返回单个构造方法对象

    //-------------------------------
    创建对象的方法
    1. T newInstance(Object...initargs)
    2. setAccessible(boolean flag)
     */
    public static void main(String[] args) throws Exception {
        // 1. 获取类的字节码对象
        Class<Student> studentClass = Student.class;
        // 2. 反射构造方法对象
        // Constructor<?>[] constructors = studentClass.getConstructors();
        Constructor<Student> constructor = studentClass.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true); //取消访问检查
        // 3. 通过构造方法对象，完成实例化
        Student student = constructor.newInstance("fairy", 18);
        System.out.println(student);


    }


}
