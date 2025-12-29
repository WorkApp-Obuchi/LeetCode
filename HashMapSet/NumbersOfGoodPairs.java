package LeetCode.HashMapSet;

import java.util.HashMap;
import java.util.Map;

public class NumbersOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0; // 戻り値として使用するペアの回数
        for (int num : nums) {
            // 過去に出てきたnumの回数を確認する。出てきていなければ0回とする
            int freq = map.getOrDefault(num, 0);
            // 今の数字が過去にfreq回出ていれば、その回数分だけ良いペアが作れるので、countに足す
            count += freq;
            // そのあとで、今の数字を含めるために、回数を１増やす
            map.put(num, freq + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        NumbersOfGoodPairs solution = new NumbersOfGoodPairs();

        // testcase1
        int[] nums1 = {1,2,3,1,1,3}; // output : 4
        System.out.println("良いペアの回数 : " + solution.numIdenticalPairs(nums1));


        // testcase2
        int[] nums2 = {1,1,1,1}; // output : 6
        System.out.println("良いペアの回数 : " + solution.numIdenticalPairs(nums2));


        // testcase3
        int[] nums3 = {1,2,3}; // output : 0
        System.out.println("良いペアの回数 : " + solution.numIdenticalPairs(nums3));
    }
}
