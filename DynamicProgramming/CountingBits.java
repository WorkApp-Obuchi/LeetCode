import java.util.Arrays;
/*
 * 338. Counting Bits
 * 0 から n までの各整数について、
 * 2進数表現に含まれる「1」の個数を配列で返す問題。
 * @param n 最大の数値
 * @return 各数値の 1 の個数を格納した配列（サイズ n+1）
 */

public class CountingBits{
    public int[] countBits(int n) {
        int[] dp = new int[n + 1]; //結果を格納する配列
        //0 を2進数で表すと「0」
        dp[0] = 0;

        //1 から n まで順番に計算していく
        for(int i = 1;i <= n; i++){
           /*
             * i / 2 : 右に1ビットシフトした値
             * i % 2 : 最下位ビットが 1 なら 1、0 なら 0
             */
            dp[i] = dp[i / 2] + (i % 2);
        }
        // 0 〜 n までの結果が入った配列を返す
        return dp;
    }
    public static void main(String[] args) {

        // Solution クラスのインスタンスを作成
        CountingBits countingbits = new CountingBits();

        // ===== Example 1 =====
        int n1 = 2;
        int[] result1 = countingbits.countBits(n1);

        // 結果を表示
        System.out.println("Example 1:");
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + Arrays.toString(result1));
        // 期待値: [0, 1, 1]

        System.out.println();

        // ===== Example 2 =====
        int n2 = 5;
        int[] result2 = countingbits.countBits(n2);

        // 結果を表示
        System.out.println("Example 2:");
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + Arrays.toString(result2));
        // 期待値: [0, 1, 1, 2, 1, 2]
    }
}