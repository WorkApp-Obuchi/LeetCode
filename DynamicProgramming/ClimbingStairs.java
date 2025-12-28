/*
 * 70. Climbing Stairs
 * n 段の階段を 1 段または 2 段ずつ登るときの
 * 到達方法の総数を返す。
 * @param n 階段の段数
 * @return n 段目に到着する方法の数
 */
public class ClimbingStairs{
    public int climbStairs(int n) {
        // n　が 2 以下の場合はnを返す
        if(n <= 2) return n;

        int[] dp = new int[n + 1];
        // 1段目に行く方法は 1 通り
        dp[1] = 1;
        // 2段目に行く方法は 2 通り
        dp[2] = 2;
        // 3段目以降は「直前2つの段」から来る
        for(int i = 3; i <= n; i++){
            // この2つを足したものが i 段目の通り数
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];// n 段目にたどり着く方法の数を返す
    }
    //実行用main
    public static void main(String[] args) {

        ClimbingStairs ClimbingStairs = new ClimbingStairs();

        // Example 1
        int n1 = 2;
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + ClimbingStairs.climbStairs(n1));
        // 期待値: 2

        System.out.println();

        // Example 2
        int n2 = 3;
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + ClimbingStairs.climbStairs(n2));
        // 期待値: 3
    }
}