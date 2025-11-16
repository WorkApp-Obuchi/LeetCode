package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Problem 118: Pascal's Triangle
 * パスカルの三角形を生成するクラス
 *
 * パスカルの三角形の特性：
 * 1. 各行の最初と最後の要素は必ず1
 * 2. それ以外の要素は、直上の行の隣接する2つの要素の和
 * 3. n行目にはn個の要素が存在する
 *
 * 例：
 *     1        <- 1行目
 *    1 1       <- 2行目
 *   1 2 1      <- 3行目
 *  1 3 3 1     <- 4行目
 * 1 4 6 4 1    <- 5行目
 *
 * @author [Your Name]
 * @version 1.0
 */
public class PascalTriangle {

    /**
     * 指定された行数のパスカルの三角形を生成する
     *
     * アルゴリズムの流れ：
     * 1. 各行を順番に生成（0行目から開始）
     * 2. 各行の最初に1を追加
     * 3. 2行目以降は中間要素を計算（前の行の隣接要素の和）
     * 4. 2行目以降は最後に1を追加
     *
     * @param numRows 生成する行数（0以上の整数）
     * @return パスカルの三角形を表す2次元リスト
     *         numRows <= 0 の場合は空のリストを返す
     *
     * 時間計算量: O(n²) - n行のそれぞれに対して最大n個の要素を処理
     * 空間計算量: O(n²) - 結果を格納するための2次元リスト
     */
    public List<List<Integer>> generate(int numRows) {
        // 結果を格納する2次元リスト
        List<List<Integer>> triangle = new ArrayList<>();

        // エッジケース：行数が0以下の場合は空のリストを返す
        if (numRows <= 0) {
            return triangle;
        }

        // 各行を生成するループ（0-indexed）
        for (int i = 0; i < numRows; i++) {
            // 現在の行を表すリスト
            List<Integer> currentRow = new ArrayList<>();

            // ステップ1: 行の最初の要素は必ず1
            currentRow.add(1);

            // ステップ2: 中間要素の計算（2行目以降のみ）
            if (i > 0) {
                // 前の行を取得（i-1行目）
                List<Integer> previousRow = triangle.get(i - 1);

                // 中間要素を計算
                // j は現在の行の要素位置（1から i-1 まで）
                for (int j = 1; j < i; j++) {
                    // 前の行の隣接する2つの要素を足し合わせる
                    // previousRow[j-1] + previousRow[j]
                    int sum = previousRow.get(j - 1) + previousRow.get(j);
                    currentRow.add(sum);
                }

                // ステップ3: 行の最後の要素も1（2行目以降）
                currentRow.add(1);
            }
            // 注意：1行目（i=0）の場合、最初の1だけが追加される

            // 完成した行を三角形に追加
            triangle.add(currentRow);
        }

        return triangle;
    }

    /**
     * パスカルの三角形を見やすく表示するヘルパーメソッド
     *
     * @param triangle 表示する三角形
     * @param label 表示時のラベル
     */
    private static void printTriangle(List<List<Integer>> triangle, String label) {
        System.out.println("\n=== " + label + " ===");
        if (triangle.isEmpty()) {
            System.out.println("(空の三角形)");
            return;
        }

        // 最大幅を計算（整形のため）
        int maxWidth = triangle.size();

        for (int i = 0; i < triangle.size(); i++) {
            // インデント（三角形の形にするため）
            for (int space = 0; space < maxWidth - i - 1; space++) {
                System.out.print(" ");
            }

            // 行の要素を表示
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                System.out.print(row.get(j));
                if (j < row.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    /**
     * 結果を検証するヘルパーメソッド
     *
     * @param triangle 検証する三角形
     * @return 正しいパスカルの三角形であればtrue
     */
    private static boolean validateTriangle(List<List<Integer>> triangle) {
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);

            // 各行の要素数が正しいか確認（i+1個）
            if (row.size() != i + 1) {
                return false;
            }

            // 最初と最後の要素が1であることを確認
            if (row.get(0) != 1 || row.get(row.size() - 1) != 1) {
                return false;
            }

            // 中間要素が正しく計算されているか確認（2行目以降）
            if (i > 0) {
                List<Integer> prevRow = triangle.get(i - 1);
                for (int j = 1; j < row.size() - 1; j++) {
                    int expected = prevRow.get(j - 1) + prevRow.get(j);
                    if (row.get(j) != expected) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * メインメソッド：テストケースの実行
     */
    public static void main(String[] args) {
        PascalTriangle solution = new PascalTriangle();

        // テストケース1: 標準的なケース（5行）
        int numRows1 = 5;
        List<List<Integer>> result1 = solution.generate(numRows1);
        printTriangle(result1, "5行のパスカルの三角形");
        System.out.println("検証結果: " + (validateTriangle(result1) ? "✓ 正しい" : "✗ 誤り"));
        System.out.println("期待値: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]");
        System.out.println("実際値: " + result1);

        // テストケース2: 最小ケース（1行）
        int numRows2 = 1;
        List<List<Integer>> result2 = solution.generate(numRows2);
        printTriangle(result2, "1行のパスカルの三角形");
        System.out.println("検証結果: " + (validateTriangle(result2) ? "✓ 正しい" : "✗ 誤り"));
        System.out.println("期待値: [[1]]");
        System.out.println("実際値: " + result2);

        // テストケース3: エッジケース（0行）
        int numRows3 = 0;
        List<List<Integer>> result3 = solution.generate(numRows3);
        printTriangle(result3, "0行のパスカルの三角形");
        System.out.println("期待値: []");
        System.out.println("実際値: " + result3);

        // テストケース4: 負の数
        int numRows4 = -1;
        List<List<Integer>> result4 = solution.generate(numRows4);
        System.out.println("\n=== 負の行数（-1）===");
        System.out.println("期待値: []");
        System.out.println("実際値: " + result4);

        // テストケース5: 大きめの三角形（10行）
        int numRows5 = 10;
        List<List<Integer>> result5 = solution.generate(numRows5);
        printTriangle(result5, "10行のパスカルの三角形");
        System.out.println("検証結果: " + (validateTriangle(result5) ? "✓ 正しい" : "✗ 誤り"));

        // パフォーマンステスト
        System.out.println("\n=== パフォーマンステスト ===");
        long startTime = System.nanoTime();
        List<List<Integer>> largeTriangle = solution.generate(30);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0; // ミリ秒に変換
        System.out.println("30行の生成時間: " + duration + " ms");
        System.out.println("検証結果: " + (validateTriangle(largeTriangle) ? "✓ 正しい" : "✗ 誤り"));
    }
}

/**
 * 実装のポイント（復習用）：
 *
 * 1. データ構造の選択
 *    - List<List<Integer>> を使用（動的配列で行と要素数が可変）
 *    - ArrayListは要素の追加がO(1)で効率的
 *
 * 2. アルゴリズムの核心
 *    - 1行目は特別扱い（要素が1つだけ）
 *    - 2行目以降は「前の行の隣接要素の和」という規則を利用
 *    - インデックスの管理が重要（off-by-oneエラーに注意）
 *
 * 3. エッジケース
 *    - numRows <= 0 の処理
 *    - 1行だけの場合の処理
 *
 * 4. 実務での改善点
 *    - 入力値の検証（nullチェック、最大値チェック）
 *    - メモリ効率の考慮（大きな三角形の場合）
 *    - イテレータパターンの使用（必要に応じて）
 *
 * 5. よくある間違い
 *    - ループの開始インデックス（0 vs 1）
 *    - 最初の行の処理を忘れる
 *    - 中間要素の計算時のインデックスミス
 *
 * 6. 応用
 *    - 二項係数の計算
 *    - 組み合わせ数学の問題
 *    - 動的計画法の基礎問題として
 */