package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) {
            throw new IllegalArgumentException("配列の要素は2つ以上必要です。");
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if(map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();

        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = ts.twoSum(nums, target);
        System.out.println("テスト１" + Arrays.toString(result));

        int[] nums2 = {3,2,4};
        int target2 = 6;
        int[] result2 = ts.twoSum(nums2, target2);
        System.out.println("テスト２" + Arrays.toString(result2));

        int[] nums3 = {3,3};
        int target3 = 6;
        int[] result3 = ts.twoSum(nums3, target3);
        System.out.println("テスト３" + Arrays.toString(result3));


    }
}
