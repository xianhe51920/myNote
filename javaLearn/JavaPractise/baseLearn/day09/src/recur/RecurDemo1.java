package recur;

import java.util.Scanner;

public class RecurDemo1 {
    /*
    使用递归求n的阶乘
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getFact(sc.nextInt()));
    }

    public static int getFact(int n){
        if(n == 1) return 1;
        return n * getFact(n-1);
    }
}
