package LeetCode.ArrayString;

import java.util.Arrays;

public class MoveZeros {
    public void moveZeros(int[] nums){
        if (nums == null) return;

        int nonZeroIndex = 0;
        int runnerIndex = 0;

        while (runnerIndex < nums.length) {
            // non: 0 runner: 0 runner++,
            if (nums[nonZeroIndex] == 0 && nums[runnerIndex] == 0){
                runnerIndex++;
            } else if (nums[nonZeroIndex] == 0 && nums[runnerIndex] != 0) {
                // non: 0 runner: 1 swap, non++, runner++,
                swap(nums, nonZeroIndex, runnerIndex);
                nonZeroIndex++;
                runnerIndex++;
            } else if (nums[nonZeroIndex] != 0 && nums[runnerIndex] == 0) {
                // non: 1 runner: 0 runner++,
                runnerIndex++;
            } else {
                // non: 1 runner: 1 non++, runner++
                nonZeroIndex++;
                runnerIndex++;
            }
        }
    }
    private void swap(int[] nums, int nonZeroIndex, int runnerIndex) {
        int tmp = nums[runnerIndex];
        nums[runnerIndex] = nums[nonZeroIndex];
        nums[nonZeroIndex] = tmp;
    }

    public static void main(String[] args) {
        MoveZeros solution = new MoveZeros();
        int[] nums1 = {0,1,0,3,12};
        int[] nums2 = {0};

        // nums1 : 移動前
        System.out.println("nums1(移動前）: " + Arrays.toString(nums1));
        solution.moveZeros(nums1);
        // nums1 : 移動後
        System.out.println("nums1(移動後） : " + Arrays.toString(nums1));

        // nums2 : 移動前
        System.out.println("nums2(移動前） : " + Arrays.toString(nums2));
        solution.moveZeros(nums2);
        // nums2 : 移動後
        System.out.println("nums2(移動後） : " + Arrays.toString(nums2));
    }
}
