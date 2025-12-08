package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return new int[0];
        if(nums1.length == 0 || nums2.length == 0) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums1) {
            map.put(num, 1);
        }
        int intersectionNum = 0;
        for(int num : nums2) {
            if(map.containsKey(num) && map.get(num) == 1) {
                map.put(num, 0);
                intersectionNum++;
            }
        }
        int[] results = new int[intersectionNum];
        int index = 0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 0) {
                results[index++] = entry.getKey();
            }
        }
    return results;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays solution = new IntersectionOfTwoArrays();

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
