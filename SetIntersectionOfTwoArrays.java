package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetIntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return new int[0];
        if(nums1.length == 0 || nums2.length == 0) return new int[0];

        Set<Integer> set = new HashSet<>();
        for(int num : nums1) {
            set.add(num);
        }
        Set<Integer> result = new HashSet<>();
        for(int num : nums2) {
            if(set.contains(num)) {
                result.add(num);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
    public static void main(String[] args) {
        SetIntersectionOfTwoArrays solution = new SetIntersectionOfTwoArrays();

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        int[] nums3 = {4,9,5};
        int[] nums4 = {9,4,9,8,4};

        int[] result1 = solution.intersection(nums1, nums2);
        int[] result2 = solution.intersection(nums3, nums4);

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }
}
