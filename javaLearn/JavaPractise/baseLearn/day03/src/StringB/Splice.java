package StringB;

public class Splice {
    /*
    需求：定义一个方法，把 `int` 数组中的数据按照指定的格式拼接成一个字符串返回。调用该方法，并在控制台输出结果
    例如：数组为 `int[] arr = {1,2,3};` → 输出 `[1, 2, 3]`
    */
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        arrPrint(arr);

    }
    public static void arrPrint(int[] arr){
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < arr.length-1; i++) {
            s.append(arr[i]).append(", ");
        }
        s.append(arr[arr.length-1]).append(']');

        System.out.println(s);
    }
}
