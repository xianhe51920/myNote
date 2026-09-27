package anno;

import java.lang.reflect.Method;

public class JDKAnnoTest1 {
    /*
    需求：自定义一个注解@Test，用于指定类的方法上
        如果类中某个的方法上使用了该注解，就执行该方法
     */
    @SuppressWarnings("all")
    public static void main(String[] args) throws Exception {
        // 获取字节码对象
        Class<MyMethod> methodClass = MyMethod.class;
        // 获取实例对象
        MyMethod myMethod = methodClass.getConstructor().newInstance();
        // 获取成员方法对象数组
        Method[] methods = methodClass.getMethods();
        // 遍历
        for(Method m : methods){
            if(m.isAnnotationPresent(Test.class)){
                m.invoke(myMethod);
            }
        }


    }
}

class MyMethod {
    public MyMethod(){

    }
    @Test
    public void method1() {
        System.out.println("我是方法1");
    }

    public void method2() {
        System.out.println("我是方法2");
    }

    public void method3() {
        System.out.println("我是方法3");
    }

    @Test
    public void method4() {
        System.out.println("我是方法4");
    }
}