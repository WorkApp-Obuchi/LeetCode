package LeetCode.ArrayString;

import java.util.Map;
import java.util.HashMap;

public class ContainsDuplicate2 {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return false;

        Map<Integer, Boolean> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num)) {
               return true;
            }
            map.put(num, false);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1};
        int[] nums2 = {1,2,3,4};
        int[] nums3 = {1,1,1,3,3,4,3,2,4,2};

        ContainsDuplicate2 solution = new ContainsDuplicate2();
        boolean result1 = solution.containsDuplicate(nums1);
        boolean result2 = solution.containsDuplicate(nums2);
        boolean result3 = solution.containsDuplicate(nums3);

        System.out.println("nums1 : " + result1); // true
        System.out.println("nums2 : " + result2); // false
        System.out.println("nums3 : " + result3); // true
    }
}
