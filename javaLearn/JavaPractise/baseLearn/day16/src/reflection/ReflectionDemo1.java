package reflection;

import pojo.Student;

public class ReflectionDemo1 {
    /*
    反射获取类的字节码对象

    1. Class.forName("全类名");
    2. 类名.class
    3. 对象.getClass();
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // 1.
        Class<?> class1 = Class.forName("pojo.Student");
        // 2.
        Class<Student> class2 = Student.class;
        // 3.
        Student student = new Student();
        Class<? extends Student> class3 = student.getClass();

        System.out.println(class1 == class2);
        System.out.println(class2 == class3);
        System.out.println(class3 == class1);
    }
}
