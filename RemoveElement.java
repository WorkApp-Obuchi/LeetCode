package LeetCode;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;

        int start = 0;
        int end = 0;

        while(end < nums.length) {
            if(nums[end] != val) {
                swap(nums, start, end);
                start++;
            }
            end++;
        }
        return start;
    }

    private void swap(int[] nums, int start, int end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();

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
