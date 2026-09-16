package Stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo2 {
    /**
     * 收集操作
     */
    public static void main(String[] args) {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).collect(Collectors.toList());
        System.out.println(list);

        java.util.Set<Integer> set = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).collect(Collectors.toSet());
        System.out.println(set);

        Map<String, String> map = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).collect(Collectors.toMap(integer -> integer + "", Object::toString));
        System.out.println(map);
    }
}
