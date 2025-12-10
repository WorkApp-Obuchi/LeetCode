package LeetCode;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2 == null) return new int[0];
        if(nums1.length == 0 || nums2.length == 0) return new int[0];

        Map<Integer,Integer> map = new HashMap<>();
        for(int num1 : nums1) {
            //map.put(num1, 1);
            map.put(num1, map.getOrDefault(num1, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();

        for(int num2 : nums2) {
            if(map.containsKey(num2) && map.get(num2) > 0) {
                list.add(num2);
                map.put(num2, map.get(num2) - 1);
            }
        }

        // リストにした値を配列に入れ直す
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
    return answer;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArraysII solution = new IntersectionOfTwoArraysII();

        // testcase1
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        // testcase2
        int[] nums3 = {4,9,5};
        int[] nums4 = {9,4,9,8,4};

        int[] result1 = solution.intersect(nums1, nums2);
        int[] result2 = solution.intersect(nums3, nums4);

        System.out.println("testcase1: output : " + Arrays.toString(result1));
        System.out.println("testcase2: output : " + Arrays.toString(result2));
    }
}
