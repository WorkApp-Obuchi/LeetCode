package LeetCode.DFS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

public class ReReFrequencySort {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // int→Integerに変換
        Integer[] nums2 = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i];
        }

        Arrays.sort(nums2, (a,b) -> {
            if(map.get(a).equals(map.get(b))) {
                return b - a;
            } else {
                return map.get(b) - map.get(a);
            }
        });

        // Integer → intに変換
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            result[i] = nums2[i];
        }
        return result;
    }
}
