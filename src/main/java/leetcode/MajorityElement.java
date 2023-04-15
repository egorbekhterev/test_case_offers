package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Egor Bekhterev
 * @date: 06.04.2023
 * @project: test_cases_offers
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                var c = map.get(num) + 1;
                map.put(num, c);
            }
        }

        for (int key : map.keySet()) {
            if (Collections.max(map.values()).equals(map.get(key))) {
                return key;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        majorityElement(new int[]{3, 2, 3});
    }
}
