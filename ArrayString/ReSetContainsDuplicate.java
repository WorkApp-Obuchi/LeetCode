package LeetCode.ArrayString;

import java.util.HashSet;
import java.util.Set;

public class ReSetContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

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
