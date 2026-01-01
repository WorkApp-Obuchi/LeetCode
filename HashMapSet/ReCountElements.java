package LeetCode.HashMapSet;

public class ReCountElements {
    public int countElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
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
        ReCountElements solution = new ReCountElements();

        // testcase1
        int[] nums1 = {11,7,2,15};
        System.out.println("testcase1 : " + solution.countElements(nums1));

        // testcase2
        int[] nums2 = {-3,3,3,90};
        System.out.println("testcase2 : " + solution.countElements(nums2));

    }
}
