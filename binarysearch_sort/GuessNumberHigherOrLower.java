/*
 * 374. Guess Number Higher or Lower
 * 1 ~ n　の範囲に存在する正解の数をguess API を利用した二分探索で求めるクラス
 */

public class GuessNumberHigherOrLower extends GuessGame{
    /*
     * 正解の数を受け取り、親クラスに渡す
     * @param pick 正解となる数値
     */
    public GuessNumberHigherOrLower(int pick) {
     super(pick);
    }
    /*
     * guess API を用いて正解の数を当てる
     * @param n　数値の上限(1~n)
     * @return 正解の数
     */
    public int guessNumber(int n) {
        int left = 1 ; //探索範囲の左端
        int right = n ; //探索範囲の右端

        while(left <= right){
            // 現在の探索範囲の中央値
            int mid = left + (right - left) / 2;
            //mid が正解と比べてどうかを取得
            int result = guess(mid);

            if(result == 0){
                //正解だった場合
                return mid;
            }else if(result == 1){
                //mid が小さい → 右側を探索
                left = mid + 1 ;
            }else{
                //mid が大きい → 左側を探索
                right = mid - 1 ;
            }
        }
        return -1; //理論上ここには来ない
    }

    public static void main(String[] args) {

        // Example 1
        GuessNumberHigherOrLower sol1 = new GuessNumberHigherOrLower(6); // pick = 6
        System.out.println(sol1.guessNumber(10)); // 期待値: 6

        // Example 2
        GuessNumberHigherOrLower sol2 = new GuessNumberHigherOrLower(1); // pick = 1
        System.out.println(sol2.guessNumber(1)); // 期待値: 1

        // Example 3
        GuessNumberHigherOrLower sol3 = new GuessNumberHigherOrLower(1); // pick = 1
        System.out.println(sol3.guessNumber(2)); // 期待値: 1
    }
}

