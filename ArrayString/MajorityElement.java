package LeetCode.ArrayString;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums){

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int majorityNum = nums[0];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > nums.length / 2) {
                majorityNum = entry.getKey();
                break;
            }
        }
        return majorityNum;
    }

    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();
        int[] nums1 = {3,2,3};
        int[] nums2 = {2,2,1,1,1,2,2};

        int result1 = solution.majorityElement(nums1);
        int result2 = solution.majorityElement(nums2);

        System.out.println("result1 : [3,2,3] → majorityNum : " + result1);
        System.out.println("result2 : [2,2,1,1,1,2,2] → majorityNum : " + result2);
    }
}
