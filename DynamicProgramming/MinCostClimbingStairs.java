/*
 * 746. Min Cost Climbing Stairs
 * 最後の段の「1つ上（ゴール）」に到達するまでの最小コストを返す。
 * @param cost 各段を踏んだときにかかるコスト配列
 * @return ゴールに到達するまでの最小コスト
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length; //段数
        //dp[i] = i段目に立つまでの最小コスト
        int[] dp = new int[n];
        //0段目を踏む
        dp[0] = cost[0];
        //1段目を踏む
        dp[1] = cost[1];
        // 2段目以降を計算
        for(int i = 2; i < n; i++){
            //１つ前か２つ前の安い方からくる
            dp[i] = cost[i] + Math.min(dp[i - 1],dp[i - 2]);
        }
        //ゴールは最後の段の一つ上
        return Math.min(dp[n - 1],dp[n - 2]);
    }
    //実行用main
    public static void main(String[] args) {

        MinCostClimbingStairs MinCostClimbingStairs = new MinCostClimbingStairs();

        // Example 1
        int[] cost1 = {10, 15, 20};
        int result1 = MinCostClimbingStairs.minCostClimbingStairs(cost1);
        System.out.println("Example 1 Result: " + result1); // 15

        // Example 2
        int[] cost2 = {1,100,1,1,1,100,1,1,100,1};
        int result2 = MinCostClimbingStairs.minCostClimbingStairs(cost2);
        System.out.println("Example 2 Result: " + result2); // 6
    }
}
