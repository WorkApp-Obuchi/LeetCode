package LeetCode;

import java.util.Arrays;

/**
 * LeetCode Problem 121: Best Time to Buy and Sell Stock
 * 株式売買の最大利益 - 完全解説版
 *
 * 問題：配列pricesが与えられ、prices[i]はi日目の株価を表す。
 * 1回だけ株を買って売ることができる場合の最大利益を求める。
 *
 * 制約：
 * - 買ってから売る必要がある（時系列を守る）
 * - 利益が出ない場合は0を返す
 *
 * @author Buchi
 * @version Complete Edition
 */
public class MaxProfit_Complete {

    /**
     * ===================================================================
     * 基本実装（修正済みの正しいコード）
     * ===================================================================
     */
    public int maxProfit(int[] prices) {
        // エッジケース：nullまたは空配列
        if (prices == null || prices.length == 0) return 0;

        int minPrice = prices[0];   // これまでの最安値
        int maxProfit = 0;          // これまでの最大利益

        for (int price : prices) {
            // 今日売った場合の利益を計算
            int profit = price - minPrice;

            // 最大利益を更新（必要なら）
            if (profit >= maxProfit) {  // >=でも>でもOK
                maxProfit = profit;
            }

            // 最安値を更新（必要なら）
            if (price < minPrice) {
                minPrice = price;
            }
        }

        return maxProfit;
    }

    /**
     * ===================================================================
     * 詳細デバッグ版：各ステップを可視化
     * ===================================================================
     */
    public int maxProfitWithDetailedDebug(int[] prices) {
        if (prices == null || prices.length == 0) {
            System.out.println("配列が空のため、利益は0");
            return 0;
        }

        System.out.println("\n========================================");
        System.out.println("📊 株価配列: " + Arrays.toString(prices));
        System.out.println("========================================\n");

        int minPrice = prices[0];
        int maxProfit = 0;
        int buyDay = 0;  // 買う日を記録
        int sellDay = 0; // 売る日を記録

        System.out.println("初期設定: 最安値 = " + minPrice + ", 最大利益 = " + maxProfit);
        System.out.println();

        for (int day = 0; day < prices.length; day++) {
            int price = prices[day];
            System.out.println("【Day " + (day + 1) + "】価格: $" + price);

            // Step 1: 利益計算
            int profit = price - minPrice;
            System.out.println("  計算: 今日売る場合の利益 = $" + price + " - $" + minPrice + " = $" + profit);

            // Step 2: 最大利益の更新チェック
            if (profit > maxProfit) {
                System.out.println("  ✅ 最大利益更新！ $" + maxProfit + " → $" + profit);
                maxProfit = profit;
                sellDay = day;
                System.out.println("     売却日を Day " + (sellDay + 1) + " に更新");
            } else {
                System.out.println("  － 最大利益は $" + maxProfit + " のまま");
            }

            // Step 3: 最安値の更新チェック
            if (price < minPrice) {
                System.out.println("  ✅ 最安値更新！ $" + minPrice + " → $" + price);
                minPrice = price;
                buyDay = day;
                System.out.println("     購入日を Day " + (buyDay + 1) + " に更新");
            } else {
                System.out.println("  － 最安値は $" + minPrice + " のまま");
            }

            System.out.println("  現在の状態 → 最安値: $" + minPrice + ", 最大利益: $" + maxProfit);
            System.out.println();
        }

        // 最適な取引の詳細を表示
        if (maxProfit > 0) {
            // 実際の買い日を再計算（最大利益を生む取引）
            for (int i = 0; i < sellDay; i++) {
                if (prices[sellDay] - prices[i] == maxProfit) {
                    buyDay = i;
                    break;
                }
            }
            System.out.println("📈 最適な取引:");
            System.out.println("   Day " + (buyDay + 1) + " に $" + prices[buyDay] + " で買い");
            System.out.println("   Day " + (sellDay + 1) + " に $" + prices[sellDay] + " で売る");
            System.out.println("   利益: $" + maxProfit);
        } else {
            System.out.println("📉 利益が出る取引はありません（取引しない）");
        }

        return maxProfit;
    }

    /**
     * ===================================================================
     * 最適化版1：Math関数を使った簡潔な実装
     * ===================================================================
     */
    public int maxProfitOptimized(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = Integer.MAX_VALUE;  // 最大値で初期化
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

    /**
     * ===================================================================
     * 最適化版2：1行での更新（上級者向け）
     * ===================================================================
     */
    public int maxProfitOneLine(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = prices[0], maxProfit = 0;

        for (int price : prices) {
            // 1行で両方を更新（読みにくいが動作する）
            maxProfit = Math.max(maxProfit, price - (minPrice = Math.min(minPrice, price)));
        }

        return maxProfit;
    }

    /**
     * ===================================================================
     * アルゴリズムの正当性の証明
     * ===================================================================
     */
    public void explainCorrectness() {
        System.out.println("\n========================================");
        System.out.println("📚 なぜこのアルゴリズムが正しいか");
        System.out.println("========================================\n");

        System.out.println("【定理】");
        System.out.println("最大利益 = max(prices[j] - prices[i]) where i < j");
        System.out.println();

        System.out.println("【証明の概要】");
        System.out.println("1. ある日jに売る場合、最大利益を得るには");
        System.out.println("   それ以前の最安値の日に買うべき");
        System.out.println();
        System.out.println("2. 各日jについて「その日に売る場合の最大利益」を計算:");
        System.out.println("   profit[j] = prices[j] - min(prices[0..j-1])");
        System.out.println();
        System.out.println("3. 全ての日の中で最大の利益が答え:");
        System.out.println("   answer = max(profit[j]) for all j");
        System.out.println();

        System.out.println("【時間計算量】");
        System.out.println("O(n) - 配列を1回走査するだけ");
        System.out.println();
        System.out.println("【空間計算量】");
        System.out.println("O(1) - 変数2つ（minPrice, maxProfit）のみ");
    }

    /**
     * ===================================================================
     * よくあるパターンの解析
     * ===================================================================
     */
    public void analyzePatterns() {
        System.out.println("\n========================================");
        System.out.println("📈 典型的なパターンと結果");
        System.out.println("========================================\n");

        // パターン1：V字回復
        int[] pattern1 = {10, 2, 8};
        System.out.println("【V字回復】" + Arrays.toString(pattern1));
        System.out.println("結果: " + maxProfit(pattern1) + " (2で買い、8で売る)");
        System.out.println();

        // パターン2：上昇トレンド
        int[] pattern2 = {1, 2, 3, 4, 5};
        System.out.println("【上昇トレンド】" + Arrays.toString(pattern2));
        System.out.println("結果: " + maxProfit(pattern2) + " (1で買い、5で売る)");
        System.out.println();

        // パターン3：下降トレンド
        int[] pattern3 = {5, 4, 3, 2, 1};
        System.out.println("【下降トレンド】" + Arrays.toString(pattern3));
        System.out.println("結果: " + maxProfit(pattern3) + " (取引しない)");
        System.out.println();

        // パターン4：W字型
        int[] pattern4 = {7, 1, 5, 2, 6};
        System.out.println("【W字型】" + Arrays.toString(pattern4));
        System.out.println("結果: " + maxProfit(pattern4) + " (1で買い、6で売る)");
        System.out.println();

        // パターン5：フラット
        int[] pattern5 = {3, 3, 3, 3, 3};
        System.out.println("【フラット】" + Arrays.toString(pattern5));
        System.out.println("結果: " + maxProfit(pattern5) + " (利益なし)");
    }

    /**
     * ===================================================================
     * 間違えやすいポイント
     * ===================================================================
     */
    public void commonMistakes() {
        System.out.println("\n========================================");
        System.out.println("⚠️ よくある間違いと対策");
        System.out.println("========================================\n");

        System.out.println("【間違い1】単純に最大値 - 最小値");
        System.out.println("例: [7, 1, 5, 3, 6, 4]");
        System.out.println("最大値6、最小値1 → 6-1=5 ✅ たまたま正解");
        System.out.println();
        System.out.println("例: [7, 6, 4, 3, 1]");
        System.out.println("最大値7、最小値1 → 7-1=6 ❌ 間違い！");
        System.out.println("（7の後に1が来るので、時系列的に不可能）");
        System.out.println();

        System.out.println("【間違い2】更新順序を間違える");
        System.out.println("❌ 先にminPriceを更新してから利益計算");
        System.out.println("```java");
        System.out.println("minPrice = Math.min(minPrice, price);  // 先に更新");
        System.out.println("maxProfit = Math.max(maxProfit, price - minPrice);");
        System.out.println("```");
        System.out.println("→ 同じ日に買って売ることになる可能性");
        System.out.println();

        System.out.println("✅ 正しい順序");
        System.out.println("```java");
        System.out.println("maxProfit = Math.max(maxProfit, price - minPrice);");
        System.out.println("minPrice = Math.min(minPrice, price);  // 後で更新");
        System.out.println("```");
    }

    /**
     * ===================================================================
     * パフォーマンス比較
     * ===================================================================
     */
    public void comparePerformance() {
        System.out.println("\n========================================");
        System.out.println("⏱️ パフォーマンス比較");
        System.out.println("========================================\n");

        // 大きなデータセットを生成
        int n = 100000;
        int[] largePrices = new int[n];
        for (int i = 0; i < n; i++) {
            largePrices[i] = (int)(Math.random() * 1000) + 1;
        }

        // 基本実装
        long start1 = System.nanoTime();
        int result1 = maxProfit(largePrices);
        long end1 = System.nanoTime();

        // 最適化版
        long start2 = System.nanoTime();
        int result2 = maxProfitOptimized(largePrices);
        long end2 = System.nanoTime();

        System.out.println("データサイズ: " + n + " 要素");
        System.out.println();
        System.out.println("基本実装:     " + String.format("%.3f", (end1 - start1) / 1_000_000.0) + " ms");
        System.out.println("最適化版:     " + String.format("%.3f", (end2 - start2) / 1_000_000.0) + " ms");
        System.out.println();
        System.out.println("結果が同じ: " + (result1 == result2));
    }

    /**
     * メインメソッド
     */
    public static void main(String[] args) {
        MaxProfit_Complete solution = new MaxProfit_Complete();

        System.out.println("========================================");
        System.out.println("   株式売買の最大利益 - 完全解説");
        System.out.println("========================================");

        // 1. 基本テスト
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};

        System.out.println("\n【基本テスト】");
        System.out.println("Test 1: " + Arrays.toString(prices1));
        System.out.println("結果: " + solution.maxProfit(prices1) + " (期待値: 5)");
        System.out.println();
        System.out.println("Test 2: " + Arrays.toString(prices2));
        System.out.println("結果: " + solution.maxProfit(prices2) + " (期待値: 0)");

        // 2. 詳細デバッグ実行
        solution.maxProfitWithDetailedDebug(prices1);

        // 3. アルゴリズムの正当性
        solution.explainCorrectness();

        // 4. パターン分析
        solution.analyzePatterns();

        // 5. よくある間違い
        solution.commonMistakes();

        // 6. パフォーマンス比較
        solution.comparePerformance();
    }
}