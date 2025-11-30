import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * 496. Next Greater Element I
 * nums1 の各要素について、nums2 の中で右側にある最初の大きい数を求める問題」
 * @param nums1 検索対象の要素が入った部分配列
 * @param nums2 nums1の要素が必ず含まれる配列。次に大きい要素を探す
 * @return nums1の各値に対応する「次に大きい要素」を格納したい配列。
 */

public class NextGreaterElementI {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();//各数字のNextGreaterを記録
        Stack<Integer> stack =new Stack<>(); //確定していないNextGreaterを記録

        //nums2のNextGreaterを確定させる
        for(int num : nums2){
            while(!stack.isEmpty() && stack.peek() < num){
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        // スタックに残ったNextGreater
        while(!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }
        // nums1 の順番で結果を返す
        int[] res = new int[nums1.length];
        for(int i = 0;i < nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {

        NextGreaterElementI nge = new NextGreaterElementI();

        // --- Example 1 ---
        int[] nums1_1 = {4, 1, 2};
        int[] nums2_1 = {1, 3, 4, 2};

        int[] result1 = nge.nextGreaterElement(nums1_1, nums2_1);
        System.out.println("Example 1 Output: " + Arrays.toString(result1));

        // --- Example 2 ---
        int[] nums1_2 = {2, 4};
        int[] nums2_2 = {1, 2, 3, 4};

        int[] result2 = nge.nextGreaterElement(nums1_2, nums2_2);
        System.out.println("Example 2 Output: " + Arrays.toString(result2));
    }
}
