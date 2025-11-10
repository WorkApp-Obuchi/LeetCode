package LeetCode;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        SearchInsert si = new SearchInsert();

        // case 1
        int[] nums1 = {1,3,5,6};
        int target1 = 5;
        int result1 = si.searchInsert(nums1, target1);
        System.out.println("result1(output:2) : " + result1);

        // case 2
        int[] nums2 = {1,3,5,6};
        int target2 = 2;
        int result2 = si.searchInsert(nums2, target2);
        System.out.println("result1(output:1) : " + result2);

        // case 3
        int[] nums3 = {1,3,5,6};
        int target3 = 7;
        int result3 = si.searchInsert(nums3, target3);
        System.out.println("result1(output:4) : " + result3);

    }
}
