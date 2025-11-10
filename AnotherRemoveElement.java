package LeetCode;

public class AnotherRemoveElement {
    public int removeElement(int[] nums, int val) {

        if(nums == null || nums.length == 0) return 0;

        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
    public static void main(String[] args) {
        AnotherRemoveElement re = new AnotherRemoveElement();

        int[] nums1 = {3,2,2,3};
        int val1 = 3;
        int result1 = re.removeElement(nums1, val1);
        System.out.println(result1); // output : 2

        int[] nums2 = {0,1,2,2,3,0,4,2};
        int val2 = 2;
        int result2 = re.removeElement(nums2, val2);
        System.out.println(result2); // output : 5
    }
}
