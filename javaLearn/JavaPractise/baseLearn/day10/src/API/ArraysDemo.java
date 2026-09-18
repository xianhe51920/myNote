package API;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysDemo {
    /*
     Arrays 数组操作类

     toString 将数组元素拼接为带有格式的字符串
     equals 比较两个数组的元素是否完全相同
     binarySearch 使用二分查找法查找元素索引，要求数组元素必须有序,未找到，返回-（插入点-1）
     sort 对数组元素进行排序，默认升序
     */
    public static void main(String[] args) {
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        Integer[] arr3 = new Integer[10];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = getRandomInt(1,10);
            arr2[i] = getRandomInt(1,10);
            arr3[i] = getRandomInt(1,10);
        }
        System.out.println("随机生成的两个数组为：");
        System.out.println(Arrays.toString(arr1)); //将数组元素拼接为带有格式的字符串
        System.out.println(Arrays.toString(arr2)); //将数组元素拼接为带有格式的字符串
        System.out.println("比较数组是否相同");
        System.out.println(Arrays.equals(arr1, arr2));
        System.out.println("给数组arr1排序：");
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        System.out.println("用比较器排序给数组arr3倒序：");
        Arrays.sort(arr3, (o1, o2) -> o2 - o1);
        System.out.println(Arrays.toString(arr3));

        System.out.println("查找arr1元素：");
        int rdint = getRandomInt(1,10);
        int idx = Arrays.binarySearch(arr1,rdint);
        if(0 <= idx && idx < arr1.length){
            System.out.println("整数" + rdint + "已找到，下标为" + idx);
        }else {
            System.out.println("未找到目标整数" + rdint + ",插入点为：" + (-idx-1));
        }
    }

    public static int getRandomInt(int n,int m){
        return (int)(Math.random() * (m - n + 1)) + n;
    }
}
