package LeetCode.HashMapSet;

import javax.management.remote.JMXAddressable;

public class CountElements {
    public int countElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int count = 0;
        for(int num : nums) {
            if(min < num && num < max) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountElements solution = new CountElements();

        // testcase1
        int[] nums1 = {11,7,2,15};
        System.out.println("testcase1 : " + solution.countElements(nums1));

        // testcase2
        int[] nums2 = {-3,3,3,90};
        System.out.println("testcase2 : " + solution.countElements(nums2));

    }
}
