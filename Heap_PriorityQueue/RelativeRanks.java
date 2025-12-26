import java.util.Arrays;
/*
 * 506. Relative Ranks
 * スコア配列を受け取り、順位文字列配列を返す
 * @param score 各選手のクラス
 * @return 順位を表す文字列配列
 */
public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        //(score,index)を保存する配列
        int[][] arr = new int[n][2];
        //score と　元のindex をセットで入れる
        for(int i = 0; i < n; i++){
            arr[i][0] = score[i]; //スコア
            arr[i][1] = i; //元の位置
        }
        //スコアの大きい順にソート
        Arrays.sort(arr,(a, b) -> b[0] - a[0]);
        //答えを入れる配列
        String[] result = new String[n];
        //順位をつけて result にもどす
        for (int i = 0; i < n; i++) {
            int index = arr[i][1];// 元の index

            switch(i){
              case 0:
                result[index] = "Gold Medal";
                break;
              case 1:
                result[index] = "Silver Medal";
                break;
              case 2:
                result[index] = "Bronze Medal";
                break;
              default:
                result[index] = String.valueOf(i + 1);
            }
        }
        return result;
    }
    //実行用main
    public static void main(String[] args) {

        RelativeRanks RelativeRanks = new RelativeRanks();

        // Example 1
        int[] score1 = {5, 4, 3, 2, 1};
        String[] result1 = RelativeRanks.findRelativeRanks(score1);
        System.out.println("Example 1:");
        System.out.println(Arrays.toString(result1)); //[Gold Medal, Silver Medal, Bronze Medal, 4, 5]
        System.out.println();

        // Example 2
        int[] score2 = {10, 3, 8, 9, 4};
        String[] result2 = RelativeRanks.findRelativeRanks(score2);
        System.out.println("Example 2:");
        System.out.println(Arrays.toString(result2)); //[Gold Medal, 5, Bronze Medal, Silver Medal, 4]
        System.out.println();
    }
}
