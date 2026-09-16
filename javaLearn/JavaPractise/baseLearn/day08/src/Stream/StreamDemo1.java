package Stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo1 {
    /**
     * Stream流思想三步骤
     * 1.将数据到流中
     * 2.中间方法
     * 2.终结方法
     */
    public static void main(String[] args) {
        // 获取流对象
        //集合
        HashSet<String> set = new HashSet<>();
        set.add("fairy");
        set.add("crane");
        set.add("mio");
        Stream<String> setStream = set.stream();
        System.out.println(setStream);

        //数组
        int[] arr = {1,2,4,5,6,5,6,3,2,6,8};
        IntStream arrStream = Arrays.stream(arr);
        arrStream.forEach(System.out::println);
        //零散数据
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        integerStream.forEach(System.out::println);

        System.out.println("_______________________");


        //中间操作
        //过滤
        set.stream().filter("fairy"::equals).forEach(System.out::println);
        //获取前几个元素
        Arrays.stream(arr).limit(3).forEach(System.out::println);
        //跳过前几个元素
        Arrays.stream(arr).skip(3).forEach(System.out::println);
        //去重
        Arrays.stream(arr).distinct().forEach(System.out::println);
        //合并
        Stream<Integer> s1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> s2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> s3 = Stream.concat(s1, s2);
        Stream<Integer> s4 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        //替换
        System.out.println(s3.map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return integer.toString();
            }
        }));
        s4.map(Object::toString).forEach(System.out::println);

        System.out.println("_______________________");

        //终结操作
        //遍历
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).forEach(System.out::println);
        //返回元素数
        System.out.println(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).count());


    }
}
