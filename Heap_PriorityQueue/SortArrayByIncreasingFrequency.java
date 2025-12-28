import java.util.Arrays;
import java.util.HashMap;
/*
 * 1636. Sort Array by Increasing Frequency
 * 配列内の数値を「出現回数の昇順」でソートする
 * ただし、出現回数が同じ場合は「数値の降順」で並べる。
 * @param nums 整数配列
 * @return ソート後の整数配列
 */
public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num :nums){
            //まだ出ていなければ 0、出ていればその回数 + 1
            map.put(num, map.getOrDefault(num , 0) + 1);
        }
        //Comparator（比較ルール）を使うため
        // int[] → Integer[] に変換する
        Integer[] arr = new Integer[nums.length];
        for(int i = 0;i < nums.length; i++){
            arr[i] = nums[i];
        }

        Arrays.sort(arr,(a,b) -> {
            //a と b の出現回数を取得
            int freqA = map.get(a);
            int freqB = map.get(b);
            //a と b の出現回数を取得
            if(freqA != freqB){
                //回数が少ない方を前にする
                return freqA - freqB;
            }
            return b - a;
        });
        //結果を int[] に戻す
        for(int i = 0; i < nums.length; i++){
            nums[i] = arr[i];
        }
        //並び替え後の配列を返す
        return nums;
    }
    //実行用main
    public static void main(String[] args) {

        SortArrayByIncreasingFrequency solution = new SortArrayByIncreasingFrequency();

        // Example 1
        int[] nums1 = {1, 1, 2, 2, 2, 3};
        System.out.println("Example 1:");
        System.out.println(Arrays.toString(solution.frequencySort(nums1)));
        System.out.println();
        //[3, 1, 1, 2, 2, 2]

        // Example 2
        int[] nums2 = {2, 3, 1, 3, 2};
        System.out.println("Example 2:");
        System.out.println(Arrays.toString(solution.frequencySort(nums2)));
        System.out.println();
        //[1, 3, 3, 2, 2]

        // Example 3
        int[] nums3 = {-1, 1, -6, 4, 5, -6, 1, 4, 1};
        System.out.println("Example 3:");
        System.out.println(Arrays.toString(solution.frequencySort(nums3)));
        System.out.println();
        //[5, -1, 4, 4, -6, -6, 1, 1, 1]
    }
}

