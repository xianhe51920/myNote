package API;

import java.util.Arrays;

public class SystemDemo {
    /*
    System类常见方法
    exit 终止运行，非零表示异常终止
    currentTimeMillis 返回当前系统的时间毫秒值形式
      - 返回1970年1月1日 0时0分0秒，到现在所经历过的毫秒值
    arraycopy 数组拷贝
     */
    public static void main(String[] args) {
        System.out.println("当前时间戳: " + System.currentTimeMillis());



        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = new int[5];
        //数组拷贝
        //源数组 起始索引 目标数组 起始索引 拷贝长度
        System.arraycopy(arr1,1,arr2,0,5);
        System.out.println("arr1:" + Arrays.toString(arr1));
        System.out.println("arr2:" + Arrays.toString(arr2));

        System.exit(0);
        System.out.println("程序终止，不打印了");
    }
}
