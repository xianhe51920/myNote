package arraylisttest;

import java.util.ArrayList;

public class altest1 {
    /*需求：创建一个存储字符串的集合，内部存储 3 个字符串元素，使用程序实现在控制台遍历该集合*/
    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<>();
        name.add("fairy");
        name.add("crane");
        name.add("mio");
        for(String s: name){
            System.out.println(s);
        }
    }
}
