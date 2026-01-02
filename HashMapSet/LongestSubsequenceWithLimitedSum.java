package LeetCode.HashMapSet;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {
    public int[] answerQueries(int[] nums, int[] queries) {
        // ①ソート（numsを小さい順に並べる）
        Arrays.sort(nums);

        // ②累積和（先頭から順に足したときの合計を記録）
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        // ③各 query について、合計が超えない最大の個数を二分探索で探す
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            result[i] = upperBound(prefix, queries[i]);
        }
        return result;
    }
    private int upperBound(int[] prefix, int target) {
        int left = 0;
        int right = prefix.length - 1;
        int ans = 0;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(prefix[mid] <= target) {
                ans = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        LongestSubsequenceWithLimitedSum solution = new LongestSubsequenceWithLimitedSum();

        // testcase1
        int[] nums1 = {4,5,2,1};
        int[] queries1 = {3,10,21};
        int[] result1 = solution.answerQueries(nums1, queries1);
        System.out.println(Arrays.toString(result1));

        // testcase2
        int[] nums2 = {2,3,4,5};
        int[] queries2 = {1};
        int[] result2 = solution.answerQueries(nums2, queries2);
        System.out.println(Arrays.toString(result2));




    }
}
