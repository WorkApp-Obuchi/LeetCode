/*
 * 88. Merge Sorted Array
 * 2つの昇順ソート済み配列を1つの配列にマージして、昇順にする。
 * 
 * 後ろからマージする方法（Reverse Two-Pointer Merge）
 * 
 * @param nums1 ソート済マージされる要素配列
 * @param m 　nums1の有効要素数
 * @param nums2 ソート済みマージした側の要素配列
 * @param n nums2の有効要素数
 */

import java.util.Arrays;

public class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
      int i = m -1; //nums1の有効要素最後(マージされる方)
      int j = n -1; //nums2の有効要素最後(マージする方)
      int k = m + n -1; //nums1の書き込みいち(最後の位置)

      while(i >=0 && j >= 0){
        if(nums1[i] >nums2[j]){ //nums1の方が大きいか判定
          nums1[k] = nums1[i]; //nums1の最後にnums2をマージ
          i--;
        }else{ //nums2のが大きい場合の処理
          nums1[k] = nums2[j];
          j--;
        }
        k--; //nums1の最後から次に進めるため
      }
      // nums2に残った要素をコピー
      while (j >= 0) {
        nums1[k] = nums2[j];
        j--;
        k--;
      }
    }
/*
 * テスト用にmainを作成
 */
    public static void main(String[] args) {
        // Example 1
        int[] nums1_example1 = {1,2,3,0,0,0};
        int[] nums2_example1 = {2,5,6};
        merge(nums1_example1, 3, nums2_example1, 3);
        System.out.println("Example 1: " + Arrays.toString(nums1_example1)); //[1,2,2,3,5,6]

        // Example 2
        int[] nums1_example2 = {1};
        int[] nums2_example2 = {};
        merge(nums1_example2, 1, nums2_example2, 0);
        System.out.println("Example 2: " + Arrays.toString(nums1_example2)); //[1]

        // Example 3
        int[] nums1_example3 = {0};
        int[] nums2_example3 = {1};
        merge(nums1_example3, 0, nums2_example3, 1);
        System.out.println("Example 3: " + Arrays.toString(nums1_example3)); //[1]
    }
}
