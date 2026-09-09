package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class CollectionDemo4 {
    /**
     * foreach方法,接口中的默认方法，传入的是接口
     */
    public static void main(String[] args) {
        Collection<String> s = new ArrayList<>();
        s.add("fairy");
        s.add("crane");
        s.add("mio");
        s.forEach(new Consumer<String>() {
            @Override
            //s是集合中的单个元素
            public void accept(String s) {
                System.out.println(s + "同学");
            }
        });

        s.forEach(s1 -> System.out.println(s1 + "前辈"));
    }
}
