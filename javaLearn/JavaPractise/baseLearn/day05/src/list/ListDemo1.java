package list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;

public class ListDemo1 {
    /**
     * List接口特点： 存取有序，有索引，可以存储重复元素
     *
     * 遍历方式
     * 迭代器
     * 增强for
     * foreach
     * 普通for循环
     * 列表迭代器(list派系下特有的迭代器)
     */
    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();
        s.add("fairy");
        s.add("crane");
        s.add("mio");
        //列表迭代器
        ListIterator<String> listit = s.listIterator();
        //正序遍历
        while(listit.hasNext()){
            System.out.println(listit.next());
        }
        //倒序遍历，了解即可，因为只有进行了正序遍历指针才会在末尾
        while(listit.hasPrevious()){
            System.out.println(listit.previous());
        }

    }
}
