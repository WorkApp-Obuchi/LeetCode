package LeetCode.StackQueue;

import java.sql.Array;
import java.util.*;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // スタックの役割: 「右側の候補」を管理
        Deque<Integer> stack = new ArrayDeque<>();

        // HashMapの役割: 「答え」を保存
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {

            int current = nums2[i];

            // スタックを使って「右側で最初に大きい数」を探す
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            // 見つけた答えをHashMapに保存！
            if (stack.isEmpty()) {
                map.put(current, -1);// 答えなし
            } else {
                map.put(current, stack.peek());// 答えあり
            }

            // 自分もスタックに追加（次の人の候補になる）
            stack.push(current);
        }
        int[] result = new int[nums1.length];
            for (int j = 0; j < nums1.length; j++) {
                result[j] = map.get(nums1[j]);
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement solution = new NextGreaterElement();
        // testcase1
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] answer1 = solution.nextGreaterElement(nums1, nums2);
        System.out.println("testcase1 : " + Arrays.toString(answer1));// output [-1,3,1]



        // testcase1
        int[] nums3 = {2,4};
        int[] nums4 = {1,2,3,4};
        int[] answer2 = solution.nextGreaterElement(nums3, nums4);
        System.out.println("testcase2 : " + Arrays.toString(answer2));// output [3,-1]

    }
}
