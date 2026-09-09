package list;

import java.util.LinkedList;

public class LinkedListDemo {
    /**
     * LinkList链表
     * addFirst
     * addLast
     * getFirst
     * getLast
     * removeFirst
     * removeLast
     */
    static LinkedList<Integer> l = new LinkedList<>();
    static {
        for(int i = 0;i<10;i++){
            l.add(i);
        }
    }

    public static void main(String[] args) {
        System.out.println(l);
        System.out.println(l.getFirst());
        System.out.println(l.getLast());
        System.out.println(l.removeFirst());
        System.out.println(l.removeLast());
        System.out.println(l);

        //表面通过索引获取元素，实际是通过遍历来获取，接近前面就正序遍历，反之倒序遍历
        for(int i= 0;i<l.size();i++){
            System.out.println(l.get(i));
        }
    }
}
