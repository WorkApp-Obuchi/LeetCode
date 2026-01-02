/*
 * 997. Find the Town Judge
 * inDegree / outDegree を使ってジャッジを探す
 *
 * @param n     町の人数（1 ～ n）
 * @param trust 信頼関係の配列
 * @return      ジャッジの番号。存在しなければ -1
 */
public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        // 各人が「信頼している人数（出次数）」
        int[] out = new int[n + 1];
        // 各人が「信頼されている人数（入次数）」
        int[] in = new int[n + 1];
        // trust 配列を 1 回なめて、in / out をカウント
        for(int[] t : trust){
            int a = t[0];
            int b = t[1];

            out[a]++; // a は誰かを信頼している
            in[b]++;  // b は誰かに信頼されている
        }
        // 条件を満たす人物を探す
        for (int i = 1; i <= n; i++) {
            // ① 誰も信頼していない
            // ② 全員から信頼されている
            if (out[i] == 0 && in[i] == n - 1) {
                return i ;
            }
        }
        // 条件を満たす人がいない場合
        return -1 ;
    }
    //実行用main
   public static void main(String[] args) {

        FindTheTownJudge solution = new FindTheTownJudge();

        // ===== Example 1 =====
        int n1 = 2;
        int[][] trust1 = {
                {1, 2}
        };
        int result1 = solution.findJudge(n1, trust1);
        System.out.println("Example 1 Result: " + result1); // 2

        // ===== Example 2 =====
        int n2 = 3;
        int[][] trust2 = {
                {1, 3},
                {2, 3}
        };
        int result2 = solution.findJudge(n2, trust2);
        System.out.println("Example 2 Result: " + result2); // 3

        // ===== Example 3 =====
        int n3 = 3;
        int[][] trust3 = {
                {1, 3},
                {2, 3},
                {3, 1}
        };
        int result3 = solution.findJudge(n3, trust3);
        System.out.println("Example 3 Result: " + result3); // -1
    }
}
