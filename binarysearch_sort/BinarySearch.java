/* 704. Binary Search
 * 二分探索を使用して中央からtargetと一致する値を返す。
 * @param nums ソートされた配列
 * @param target 探す値
 * @return targetと一致するインデックス
 */

import java.util.Arrays;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1 ;

        while( left <= right){
            int mid = left + (right - left) / 2; //中央を出す
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target ){
                left = mid + 1 ; //左に進めたい
            }else{
                right = mid -1 ; //右に進めたい
            }
        }
        return -1 ;
    }
    //実行用main
    public static void main(String[] args) {

        BinarySearch BinarySearch = new BinarySearch();

        // ---- Example 1 ----
        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        int result1 = BinarySearch.search(nums1, target1);

        System.out.println("Example 1");
        System.out.println("nums = " + Arrays.toString(nums1));
        System.out.println("target = " + target1);
        System.out.println("Output = " + result1); // 4

        // ---- Example 2 ----
        int[] nums2 = {-1, 0, 3, 5, 9, 12};
        int target2 = 2;
        int result2 = BinarySearch.search(nums2, target2);

        System.out.println("\nExample 2");
        System.out.println("nums = " + Arrays.toString(nums2));
        System.out.println("target = " + target2);
        System.out.println("Output = " + result2); // -1
    }
}
