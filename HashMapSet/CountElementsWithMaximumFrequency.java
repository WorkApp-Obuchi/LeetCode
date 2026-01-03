package LeetCode.HashMapSet;

import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaximumFrequency {
    public int maxFrequencyElements(int[] nums) {
        // step 1 : 頻度をカウントする
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // step 2 : 最大頻度を見つける
        int maxFreq = 0;
        for(int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }
        // step 3 : 最大頻度をもつ要素の頻度を合計
        int result = 0;
        for(int freq : map.values()) {
            if(freq == maxFreq) {
                result += freq;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountElementsWithMaximumFrequency solution = new CountElementsWithMaximumFrequency();

        // testcase1
        int[] nums1 = {1,2,2,3,1,4};
        int answer1 = solution.maxFrequencyElements(nums1);
        System.out.println("testcase1 : " + answer1);

        // testcase2
        int[] nums2 = {1,2,3,4,5};
        int answer2 = solution.maxFrequencyElements(nums2);
        System.out.println("testcase2 : " + answer2);
    }
}
