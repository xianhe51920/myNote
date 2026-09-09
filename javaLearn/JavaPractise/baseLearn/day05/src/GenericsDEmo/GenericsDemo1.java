package GenericsDEmo;

import pojo.Student;

public class GenericsDemo1 {
    public static void main(String[] args) {
        String[] arr1 = {"张三", "李四", "王五"};
        Integer[] arr2 = {1,2,3,4,5,6,7,8,9};
        Double[] arr3 = {1.1,2.2,3.3,4.4,5.5};
        printArray(arr1);
        printArray(arr2);
        printArray(arr3);


    }

    /**
     * 泛型类
     */
    public static class Student<E>{
        private E e;
//        非静态方法：跟着类的泛型去匹配的，在创建对象的时候确定具体的类型
        public E getE(){
            return this.e;
        }
    }

    /**
     * 泛型方法
     * 调用方法传入实际参数再确认具体类型，只能接收引用数据类型
     * 静态方法：调用方法的时候，传入实际参数，在这时候确定到具体的数据类型
     * @param arr 传入的数组
     * @param <T> 泛型类
     */
    public static <T> void printArray(T[] arr){
        System.out.println("[");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i] + ",");
        }
        System.out.println("]");
    }
}
