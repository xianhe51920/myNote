package collection;

import pojo.Student;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo1 {
    /**
    Collection常用方法
    add 添加元素到集合
    clear 清空集合
    isEmpty 判断集合是否为空
    remove 移除集合指定对象
    contains 判断集合是否包含某对象，底层依赖euqals方法
    size 返回集合元素个数
     */
    public static void main(String[] args) {
        Collection<Student> s = new ArrayList<>();
        s.add(new Student("fairy", 18));
        s.add(new Student("crane", 17));
        System.out.println(s.add(new Student("mio", 16))); // 返回是否添加成功
        System.out.println(s.size());
        System.out.println(s.isEmpty());
        System.out.println(s.contains(new Student("fairy", 18)));
        s.clear();
        System.out.println(s.size());
        System.out.println(s.isEmpty());

    }

}
