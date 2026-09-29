package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class ProxyDemo {
    /*
        Proxy 类
        static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)

        参数一：用于指定用哪个类加载器，去加载生成的实现类
        参数二：指定接口，这些接口用于指定生成的实现类中有什么，也就是有哪些方法
        参数三：用来指定生成的实现类中不同方法的实现方案
     */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("fairy");

        List<String> newList = (List<String>) Proxy.newProxyInstance(
                ProxyDemo.class.getClassLoader(), // ClassLoader.getSystemClassLoader() 也可以
                new Class[]{List.class},
                new InvocationHandler() {
                    // proxy 生成的代理对象，一般放在这里不用
                    // method 代理的方法
                    // args 调用方法的时候，传入的实际参数
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 计算add方法耗时
                        long begin = System.currentTimeMillis();
                        Object result = method.invoke(list, args);
                        long end = System.currentTimeMillis();
                        System.out.println(method.getName() + "方法耗时" + (end - begin) + "毫秒");
                        return result;
                    }
                });
        newList.add("crane");
        newList.clear();
        System.out.println(list);
    }
}
