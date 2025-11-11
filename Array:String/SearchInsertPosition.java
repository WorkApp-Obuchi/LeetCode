/*
 * 35.Search Insert Position
 * ソートされた配列にターゲットの位置を探す
 *
 * 二分探索（Binary Search)：検索範囲を半分にしながら検索する
 * 
 * @param numsソートされた配列
 * @param target ターゲット整数
 * @return targetが存在する場合はインデックス、なければ挿入する位置を返す
 */
public class SearchInsertPosition {
  public static int searchInsert(int[] nums, int target) {
        int left = 0; //先頭から
        int right = nums.length - 1; //末尾から

        while(left<= right){
            int mid = left +(right - left) / 2; //真ん中がどれか
            if(nums[mid] == target){
                return mid; //見つかったら返す
            }else if(nums[mid] < target){
                left = mid + 1; //ターゲットは右側
            }else{
                right = mid - 1;//ターゲットは左側
            }
        }
        return left; //見つからない場合の挿入位置(先頭から何番目に入れるか)
    }
    //テスト用にmainを作成
    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        System.out.println("Example 1: " + searchInsert(nums1, target1)); // 出力: 2

        // Example 2
        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        System.out.println("Example 2: " + searchInsert(nums2, target2)); // 出力: 1

        // Example 3
        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        System.out.println("Example 3: " + searchInsert(nums3, target3)); // 出力: 4
    }
}
