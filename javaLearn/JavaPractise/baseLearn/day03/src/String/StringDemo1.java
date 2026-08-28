package String;

import java.util.Objects;

public class StringDemo1 {
    public static void main(String[] args) {
        String s = "abc";
        String b = new String("abc");
        System.out.println(s == b);
        System.out.println(Objects.equals(s,b));
    }
}
