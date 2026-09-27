package reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectionTest1 {
    /*
    练习：往泛型为Integer的集合中添加字符串
    提示：Java的泛型只在编译阶段有效
     */
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Class<? extends ArrayList> aClass = list.getClass();
        Method add = aClass.getMethod("add", Object.class);
        add.invoke(list,"fairy");
        System.out.println(list);
    }
}
