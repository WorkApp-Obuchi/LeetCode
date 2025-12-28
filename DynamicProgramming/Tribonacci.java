/*
 * 1137. N-th Tribonacci Number
 * トリボナッチ数列を計算する者dない
 * 定義:
 *      T0 = 0
 *      T1 = 1
 *      T2 = 2
 *      Tn = T(n - 1) + T(n - 2) + T(n - 3)
 * @param n 求めたいトリボナッチ数のインデックス
 * @return n番目のトリボナッチ数
 */

public class Tribonacci {
    public int tribonacci(int n) {
        //ベースケース
        if(n == 0) return 0; //T0の場合は0を返す
        if(n <= 2) return 1; //T1,T2の場合は1を返す
        //dp[i] : i番目のトリボナッチ数を表す
        int[] dp = new int[n + 1];
        dp[0] = 0 ; //T0
        dp[1] = 1 ; //T1
        dp[2] = 1 ; //T3
        // トリボナッチ数列の定義に従って下から順に計算
        // Tn = T(n-1) + T(n-2) + T(n-3)
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1]+ dp[i - 2] + dp[i - 3];
        }
        //n番目のトリボナッチ数を返す
        return dp[n];
    }
    //実行用main
    public static void main(String[] args) {
        Tribonacci solution = new Tribonacci();

        // // Example 1
        // int n1 = 4;
        // System.out.println("Input: n = " + n1);
        // System.out.println("Output: " + solution.tribonacci(n1));
        // // 期待値: 4

        // Example 2
        int n2 = 25;
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + solution.tribonacci(n2));
        // 期待値: 1389537
    }
}
