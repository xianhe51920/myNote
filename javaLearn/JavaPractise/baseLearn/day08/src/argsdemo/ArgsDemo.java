package argsdemo;

public class ArgsDemo {

    public static void main(String[] args) {
        System.out.println(getSum(1, 2, 34, 5));
    }

    /**
     * 可变参数，在方法中只能有一个
     * 如果方法中除了可变参数，还有其他的参数，需要将可变参数放在最后
     * @param args 可变参数，可以接收多个值，是个数组
     * @return
     */
    public static int getSum(int...args){
        int sum = 0;
        for(int i : args){
            sum += i;
        }
        return sum;
    }
}
