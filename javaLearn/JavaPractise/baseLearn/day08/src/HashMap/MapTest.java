package HashMap;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    /**
     * 需求，给定字符串，统计每一个字符出现次数
     */
    public static void main(String[] args) {
        String s = "aababcabcdabcde";
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),(map.getOrDefault(s.charAt(i), 0)) + 1);
        }

        StringBuilder s1 = new StringBuilder();
        map.forEach((k,v) -> {
            s1.append(k).append("(").append(v).append(")");
        });
        System.out.println(s1);
    }
}
