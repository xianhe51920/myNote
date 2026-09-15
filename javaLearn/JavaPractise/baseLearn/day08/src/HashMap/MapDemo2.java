package HashMap;

import java.util.*;
import java.util.function.BiConsumer;

public class MapDemo2 {
    /**
     * map的三种遍历方式：
     * 1.通过键找值
     * 2.通过键值对对象获取键和值
     * 3.通过foreach遍历
     */
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("fairy","北京");
        map.put("jerry","上海");
        map.put("tom","广州");
        System.out.println(map);

        //1.通过键找值
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key+"-"+map.get(key));
        }

        //2.通过键值对对象获取键和值
        Set<Map.Entry<String,String>> entryset = map.entrySet();
        for (Map.Entry<String,String> entry : entryset) {
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }
        //3.通过foreach遍历
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s+"-"+s2);
            }
        });
        //使用lambda表达式
        map.forEach((key, value) -> System.out.println(key+"-"+value));
    }
}
