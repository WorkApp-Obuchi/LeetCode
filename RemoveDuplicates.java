package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    // ソートされた配列から重複を削除する
    // return : 重複を削除した後、一意の要素数を返却する
    public int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        if(nums.length <= 1) return nums.length;

        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        return set.size();
    }

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        int[] nums1 = {1,1,2};
        int result = rd.removeDuplicates(nums1);
        System.out.println("output(result) : " + result); // output : 2

        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        int result2 = rd.removeDuplicates(nums2);
        System.out.println("output(result2) : " + result2); // output : 5
    }
}
