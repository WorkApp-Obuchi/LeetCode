package LeetCode;

public class SearchInsert2 {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                return mid; // 見つかった
            } else if (nums[mid] < target){
                left = mid + 1; // 右側を探索
            } else {
                right = mid - 1; // 左側を探索
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInsert2 si = new SearchInsert2();

        // case 1
        int[] nums1 = {1,3,5,6};
        int target1 = 5;
        int result1 = si.searchInsert(nums1, target1);
        System.out.println("result1(output:2) : " + result1);

        // case 2
        int[] nums2 = {1,3,5,6};
        int target2 = 2;
        int result2 = si.searchInsert(nums2, target2);
        System.out.println("result2(output:1) : " + result2);

        // case 3
        int[] nums3 = {1,3,5,6};
        int target3 = 7;
        int result3 = si.searchInsert(nums3, target3);
        System.out.println("result3(output:4) : " + result3);

    }
}
