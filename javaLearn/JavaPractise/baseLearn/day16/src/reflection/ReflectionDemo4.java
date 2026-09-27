package reflection;

import pojo.Student;

import java.lang.reflect.Method;

public class ReflectionDemo4 {
    /*
    反射类中的成员方法

    1. Method[] getMethods() 返回所有公共成员方法对象的数组，包括继承的
    2. Method[] getDeclaredMethods() 返回所有成员方法对象的数组，不包括继承的
    3. Method getmethod(String name, Class<?>... parameterTypes) 返回单个公共成员方法对象
    4. Method getDeclareMethod(String name, Class</>... parameterTypes) 返回单个成员方法对象

    ------------------
    Method类的执行方法
    Object invoke(Object obj, Object... args) 运行方法
     */
    public static void main(String[] args) throws Exception {
        Class<Student> studentClass = Student.class;
        Student student = studentClass.newInstance();
        // 获取类的成员方法对象
        //Method[] methods = studentClass.getMethods();
        //for(Method m : methods){
        //    System.out.println(m);
        //}
        Method printLove = studentClass.getMethod("printLove", String.class);
        // 执行
        printLove.invoke(student,  "mio");
    }
}
