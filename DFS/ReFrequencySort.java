package LeetCode.DFS;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class ReFrequencySort {
    public int[] frequencySort(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // int → Integer
        Integer[] nums2 = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i];
        }

        Arrays.sort(nums2, (a,b) -> {
            if(map.get(a).equals(map.get(b))) {
                return b - a;
            } else {
                return map.get(a) - map.get(b);
            }
        });

        // Integer → int
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            result[i] = nums2[i];
        }
        return result;
    }
}
