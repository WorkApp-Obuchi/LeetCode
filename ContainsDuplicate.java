package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() >= 2) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1};
        int[] nums2 = {1,2,3,4};
        int[] nums3 = {1,1,1,3,3,4,3,2,4,2};

        ContainsDuplicate solution = new ContainsDuplicate();
        boolean result1 = solution.containsDuplicate(nums1);
        boolean result2 = solution.containsDuplicate(nums2);
        boolean result3 = solution.containsDuplicate(nums3);

        System.out.println("nums1 : " + result1); // true
        System.out.println("nums2 : " + result2); // false
        System.out.println("nums3 : " + result3); // true
    }
}
