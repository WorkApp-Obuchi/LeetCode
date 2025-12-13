package LeetCode.ArrayString;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        // numsが空かどうかを判定する
        if(nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1)
                return entry.getKey();
        }
        return -1;
    }

    public static void main(String[] args) {
        SingleNumber solution = new SingleNumber();
        int[] nums1 = {2,2,1};
        int[] nums2 = {4,1,2,1,2};
        int[] nums3 = {1};

        int result1 = solution.singleNumber(nums1);
        int result2 = solution.singleNumber(nums2);
        int result3 = solution.singleNumber(nums3);

        System.out.println("nums1 : " +result1);
        System.out.println("nums2 : " +result2);
        System.out.println("nums3 : " +result3);

    }
}
