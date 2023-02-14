package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CharRepetition {

    private static Map<Character, Integer> charRep(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.merge(ch, 1, Integer::sum);
        }
        return map;
    }

    public static void main(String[] args) {
        var x = charRep("Java");
        var z = charRep("Language");
        for (Map.Entry<Character, Integer> entry : x.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(entry.getValue());
        }
        System.out.println(System.lineSeparator());
        for (Map.Entry<Character, Integer> entry : z.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(entry.getValue());
        }
    }
}
