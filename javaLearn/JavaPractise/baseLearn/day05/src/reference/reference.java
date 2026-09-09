package reference;

import java.util.ArrayList;
import java.util.Collection;

public class reference {
    /**
     * 方法引用
     */
    public static void main(String[] args) {
        Collection<String> s = new ArrayList<>();
        s.add("fairy");
        s.add("crane");
        s.add("mio");
        s.forEach(reference::change);
        //省略了一大段代码
//        s.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                change(s);
//            }
//        });
        //同理
        s.forEach(System.out::println);

        //引用非静态方法
        reference re = new reference();
        s.forEach(re::change2);

    }

    private static void change(String s) {
        System.out.println(s.toLowerCase());
    }

    private void change2(String s) {
        System.out.println(s.toLowerCase());
    }
}
