package argsdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsDemo {
    /**
     * Collections是操作集合的工具类
     * addAll 给集合批量添加元素
     * shuffle 打乱list集合元素顺序
     * max/min 根据默认的自然排序获取最大/最小值
     * sort(List<T> list) 将集合中元素按照默认规则排序
     * sort(List<T> list, Comparator<? super T> c) 将集合中元素按照指定规则排序
     */
    public static void main(String[] args) {
        ArrayList<Integer> Arr = new ArrayList<>();
        // 批量添加
        Collections.addAll(Arr,1,2,3,4,5,6,7,8,9,10);
        System.out.println(Arr);

        // 打乱顺序
        Collections.shuffle(Arr);
        System.out.println(Arr);

        //获取最值
        System.out.println(Collections.max(Arr));
        System.out.println(Collections.min(Arr));

        ArrayList<Student> stu = new ArrayList<>();
        Collections.addAll(stu,new Student("fairy",18),new Student("crane",19),new Student("mio",16));
        // 对象中要重写compareTo方法
        System.out.println(Collections.max(stu));
        System.out.println(Collections.min(stu));

        // 排序，需要重写compareTo方法
        Collections.sort(stu);
        System.out.println(stu);

        // 比较器排序
        Collections.sort(Arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arr);
    }
}
