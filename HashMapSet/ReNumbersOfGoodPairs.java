package LeetCode.HashMapSet;

import java.util.HashMap;
import java.util.Map;

public class ReNumbersOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        if(nums == null || nums.length <= 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for(int num : nums) {
            // ① 過去の出現回数を取得（自分自身は含まない）
            int freq = map.getOrDefault(num, 0);
            // ② 過去の出現回数分だけペアを作る(これまでの累計を出す、
            // freqは各値（1,2,3など）の数をfor文でループした数の回数だけ各ループで表示させるため）
            count += freq;
            // ③ 自分自身を含めた回数に更新(①では過去の回数のみ取得しているため、今回のループについては含めていないため+1をする）
            map.put(num, freq + 1);
        }
    return count;
    }
    public static void main(String[] args) {
        ReNumbersOfGoodPairs solution = new ReNumbersOfGoodPairs();

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
