package API;

import java.util.ArrayList;

public class IntegerTest {
    /*
    已知字符串
    String s = "10,50,30,20,40";

    请将该字符串转换为整数并存入数组
    随后求出最大值打印在控制台
     */
    public static void main(String[] args) {
        String s = "10,50,30,20,40";
        String[] s1 = s.split(",");
        ArrayList<Integer> arr = new ArrayList<>();
        for (String string : s1) {
            arr.add(Integer.parseInt(string));
        }

        System.out.println(getArrMax(arr));

    }

    public static int getArrMax(ArrayList<Integer> arr){
        int m = Integer.MIN_VALUE;
        for(int i : arr){
            m = Integer.max(m,i);
        }
        return m;
    }
}
