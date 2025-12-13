package LeetCode.ArrayString;

import java.util.Arrays;

public class MoveZeros2 {
    public void moveZeros(int[] nums) {
        if(nums == null) return;

        // ０ではない位置
        int nonZero = 0;

        for(int runner = 0; runner < nums.length; runner++) {
            // swapするのはrunner != 0の時だけ
            if(nums[runner] != 0) {
                if(runner != nonZero) {
                    swap(nums, nonZero, runner);
                }
                nonZero++;
            }
        }
    }
    private void swap(int[] nums, int nonZero, int runner) {
        int tmp = nums[nonZero];
        nums[nonZero] = nums[runner];
        nums[runner] = tmp;
    }

    public static void main(String[] args) {
        MoveZeros2 solution = new MoveZeros2();
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
