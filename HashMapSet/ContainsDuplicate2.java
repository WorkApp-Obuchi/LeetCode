package LeetCode.HashMapSet;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int j = map.get(nums[i]);
                if((i - j) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
    return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1};
        int[] nums2 = {1,0,1,1};
        int[] nums3 = {1,2,3,1,2,3};

        int k1 = 3;
        int k2 = 1;
        int k3 = 2;

        ContainsDuplicate2 solution = new ContainsDuplicate2();
        // testcase1
        System.out.println(solution.containsNearbyDuplicate(nums1,k1)); // true
        // testcase2
        System.out.println(solution.containsNearbyDuplicate(nums2,k2)); // true
        // testcase3
        System.out.println(solution.containsNearbyDuplicate(nums3,k3)); // false
    }
}
