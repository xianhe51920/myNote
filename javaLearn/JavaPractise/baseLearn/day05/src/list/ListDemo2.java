package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ListDemo2 {
    /**
     * 并发修改异常
     * ConcurrentModificationException
     * 使用迭代器遍历集合的过程中，调用了集合对象的添加，删除方法，就会出现此异常
     *
     * 解决方案：不允许使用集合的添加或删除方法，就使用迭代器自身的添加或删除
     */
    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();
        s.add("fairy");
        s.add("crane");
        s.add("mio");
        //列表迭代器
        ListIterator<String> listit = s.listIterator();

        //迭代过程做删除，使用Iterator自带的remove方法
        //迭代过程做添加，使用ListIterator自带的add方法
        while(listit.hasNext()){
            if("fairy".equals(listit.next())){
                listit.add("suoming ");
            }
        }

    }
}
