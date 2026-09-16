package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamTest2 {
    /**
     * 需求：两个 ArrayList 集合分别存储 6 名男演员和 6 名女演员。
     * 男演员只要名字为 3 个字的前两人
     * 女演员只要姓林的，并且不要第一个
     * 把过滤后的男演员姓名和女演员姓名合并到一起
     * 把合并后的元素作为构造方法的参数创建 Actor 对象，遍历数据
     * 演员类 Actor 含一个成员变量、一个带参构造方法、对应 get / set 方法
     */
    public static void main(String[] args) {
        // 处理

        ArrayList<String> males = new ArrayList<>(Arrays.asList(
                "蔡徐坤", "李易峰", "王俊凯", "易烊千玺", "陈伟霆", "邓伦"));
        ArrayList<String> females = new ArrayList<>(Arrays.asList(
                "林允儿", "林志玲", "杨幂", "赵丽颖", "刘亦菲", "林心如"));

        Stream<String> s1 = males.stream().filter(s -> s.length() == 3).limit(3);
        Stream<String> s2 = females.stream().filter(s -> s.startsWith("林")).skip(1);
        Stream<String> s3 = Stream.concat(s1, s2);
        s3.map(Actor::new).forEach(a -> System.out.println(a.getName()));
    }

}
     class Actor {
        private String name;
        public Actor(String name) { this.name = name; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }
