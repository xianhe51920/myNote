package recur;

public class RecurDemo2 {
    /*
    有一对兔子，从出生后第三个月起每个月都生一对兔子，
    小兔子长到第三个月后每个月又生一对兔子，
    假如兔子都不死，问第12个月的兔子对数为多少
     */
    public static void main(String[] args) {
        System.out.println(getSum(12));
    }

    public static int getSum(int n){
        if(n == 1 || n == 2) return 1;
        return getSum(n-1) + getSum(n-2);
    }
}
