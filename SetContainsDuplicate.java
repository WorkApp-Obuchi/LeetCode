package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class SetContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1) return false;

        Set<Integer> set = new HashSet<>();

        // 解法①
//        for(int num : nums) {
//            if(set.contains(num)) {
//                return true;
//            } else {
//                set.add(num);
//            }
//        }
//        return false;
        // 解法②
        for(int num : nums) {
            if(!set.add(num)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1};
        int[] nums2 = {1,2,3,4};
        int[] nums3 = {1,1,1,3,3,4,3,2,4,2};

        SetContainsDuplicate solution = new SetContainsDuplicate();
        boolean result1 = solution.containsDuplicate(nums1);
        boolean result2 = solution.containsDuplicate(nums2);
        boolean result3 = solution.containsDuplicate(nums3);

        System.out.println("nums1 : " + result1); // true
        System.out.println("nums2 : " + result2); // false
        System.out.println("nums3 : " + result3); // true
    }
}
