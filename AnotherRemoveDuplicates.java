package LeetCode;

public class AnotherRemoveDuplicates {
    public int removeDuplicates(int[] nums) {

        if(nums == null) return 0;
        if(nums.length <= 1) return nums.length;

        int k = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
    public static void main(String[] args) {
        AnotherRemoveDuplicates another = new AnotherRemoveDuplicates();
        int[] nums1 = {1,1,2};
        int result = another.removeDuplicates(nums1);
        System.out.println("output(result) : " + result); // output : 2

        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        int result2 = another.removeDuplicates(nums2);
        System.out.println("output(result2) : " + result2); // output : 5
    }
}
