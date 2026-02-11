package LeetCode.DFS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrequencySort {
    public int[] frequencySort(int[] nums) {
        // 1 出現回数を数える
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 2 int[] → Integer[]に変換
        Integer[] nums2 = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i];
        }
        // 3 カスタムソート
        Arrays.sort(nums2, (a, b) -> {
            if (map.get(a).equals(map.get(b))) {
                return b - a;
            } else {
                return map.get(a) - map.get(b);
            }
        });
        // 4 Integer[] → int[]に戻す
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            result[i] = nums2[i];
        }
        return result;
    }
}
