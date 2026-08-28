package String;

public class StringMethodDemo {
    public static void main(String[] args) {
        String s = "abcdefghi";
        char[] cArr = s.toCharArray();
        for (int i = 0;i<cArr.length;i++){
            System.out.println(cArr[i]);
        }

        for (int i = 0;i<s.length();i++){
            System.out.println(s.charAt(i));
        }
    }
}
