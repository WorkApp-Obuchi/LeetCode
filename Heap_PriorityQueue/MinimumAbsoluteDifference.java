import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * 1200. Minimum Absolute Difference
 * 配列をソートして、差の最小値を見つけて全て返す
 * @param arr 整数配列
 * @return 最小の差を持つ整数ペアのリスト
 */
public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr); //配列を昇順に並べる

        int minDiff = Integer.MAX_VALUE; //最小値の初期値(大きい値)
        //最小差を求める
        for(int i = 0;i < arr.length -1; i++){
            int diff = arr[i + 1] - arr[i]; //隣同士の差を
            //今までの最小差と今回の差を比較し、小さい方を残す
            minDiff = Math.min(minDiff,diff);
        }
        //結果を入れるリスト
        List<List<Integer>> result = new ArrayList<>();
        //再び隣同士をチェック
        for(int i = 0;i < arr.length - 1; i++){
            int diff = arr[i + 1] - arr[i]; //隣同士の差を
            if(diff == minDiff){
                //arr[i] と arr[i+1] を1つのリスト（ペア）にして追加
                result.add(Arrays.asList(arr[i],arr[i + 1]));
            }
        }
        //最小差を持つペアの一覧を返す
        return result;
    }
    public static void main(String[] args) {

        MinimumAbsoluteDifference solution = new MinimumAbsoluteDifference();

        // Example 1
        int[] arr1 = {4, 2, 1, 3};
        System.out.println("Example 1");
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + solution.minimumAbsDifference(arr1)); //Output: [[1, 2], [2, 3], [3, 4]]
        System.out.println();

        // Example 2
        int[] arr2 = {1, 3, 6, 10, 15};
        System.out.println("Example 2");
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Output: " + solution.minimumAbsDifference(arr2)); //Output: [[1, 3]]
        System.out.println();

        // Example 3
        int[] arr3 = {3, 8, -10, 23, 19, -4, -14, 27};
        System.out.println("Example 3");
        System.out.println("Input: " + Arrays.toString(arr3));
        System.out.println("Output: " + solution.minimumAbsDifference(arr3)); //Output: [[-14, -10], [19, 23], [23, 27]]
    }
}
