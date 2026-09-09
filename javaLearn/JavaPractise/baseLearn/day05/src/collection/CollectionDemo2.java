package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo2 {
    /**
     * 集合通用遍历方式，迭代器
     */
    public static void main(String[] args) {
        Collection<String> s = new ArrayList<>();
        s.add("fairy");
        s.add("crane");
        s.add("mio");
        // 通过集合对象，获取迭代器
        Iterator<String> it = s.iterator();
        //遍历
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
