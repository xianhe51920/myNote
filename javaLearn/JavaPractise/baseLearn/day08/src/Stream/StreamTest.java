package Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {
    /**
     * 将arraylist中的“zhangsan，23”/“lisi,24”/"wangwu,25"收集到map<姓名，年龄>
     */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "zhangsan,23", "lisi,24", "wangwu,25");
        System.out.println(list.stream().collect(Collectors.toMap(
                s -> s.split(",")[0],
                s -> Integer.parseInt(s.split(",")[1]))));
    }
}
