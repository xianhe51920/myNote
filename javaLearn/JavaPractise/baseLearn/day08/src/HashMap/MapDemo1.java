package HashMap;

import java.util.HashMap;

public class MapDemo1 {
    /**
     * map集合常用API
     * put 添加元素
     * remove 删除元素
     * clear 清空元素
     * containsKey 是否包含指定的key
     * containsValue 是否包含指定的value
     * size 返回map中元素个数
     * isEmpty 判断map是否为空
     */
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        System.out.println(map);
        map.remove("Bob");
        System.out.println(map);
        map.clear();
        System.out.println(map);
        System.out.println(map.containsKey("Charlie"));
        System.out.println(map.containsValue(35));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
}
