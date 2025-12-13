package LeetCode.ArrayString;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num)) {
                // 2回以上出現する場合にはtrueを返せばいいので、新たに追加する必要はない
                // 出現回数を数える必要がそもそもない
                //（重複があるかどうかだけなら、1回出た時点で return true でよい）
                //map.put(num, map.get(num) + 1); // 不要なので削除
                return true;// 追加修正
            } else {
                map.put(num, 1);
            }
        }
        // 以下の実装はバグになる
        /*
            例えば[1,2,1] の場合
             map は {1=2, 2=1} のようになるけど
            たまたま 2 が最初に取り出されたら value=1 → false を返してしまう
         */
//        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if(entry.getValue() >= 2) {
//                return true;
//            } else {
//                return false;
//            }
//        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1};
        int[] nums2 = {1,2,3,4};
        int[] nums3 = {1,1,1,3,3,4,3,2,4,2};

        ContainsDuplicate solution = new ContainsDuplicate();
        boolean result1 = solution.containsDuplicate(nums1);
        boolean result2 = solution.containsDuplicate(nums2);
        boolean result3 = solution.containsDuplicate(nums3);

        System.out.println("nums1 : " + result1); // true
        System.out.println("nums2 : " + result2); // false
        System.out.println("nums3 : " + result3); // true
    }
}
