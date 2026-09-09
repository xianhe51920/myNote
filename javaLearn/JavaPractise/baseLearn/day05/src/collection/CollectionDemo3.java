package collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo3 {
    /**
     * 集合遍历通用方式，增强for循环
     * 简化迭代器的代码书写
     */
    public static void main(String[] args) {
        Collection<String> s = new ArrayList<>();
        s.add("fairy");
        s.add("crane");
        s.add("mio");

        for(String i : s){
            System.out.println(i);
        }

        //也可用于数组
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
