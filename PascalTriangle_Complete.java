package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * パスカルの三角形 - 完全版解説と実装
 *
 * LeetCode Problem 118 & 119の両方を含む包括的な実装
 * これまでの疑問点への回答も含めた完全版
 *
 * @author Buchi
 * @version 2.0 - Complete Edition
 */
public class PascalTriangle_Complete {

    /**
     * ===================================================================
     * Problem 118: Pascal's Triangle
     * 全ての行を返す実装
     * ===================================================================
     */

    /**
     * パスカルの三角形の全ての行を生成する（標準実装）
     *
     * 問題：Given an integer numRows, return the first numRows of Pascal's triangle.
     * 要求：パスカルの三角形の最初のnumRows行を返す
     * 戻り値：List<List<Integer>> （2次元リスト - 全ての行）
     *
     * アルゴリズムの特徴：
     * - 各行を新しいリストとして作成（前の行は保持される）
     * - 前の行を「読み取り専用」として参照
     * - 更新順序は左から右でも右から左でも可能（前の行が変更されないため）
     *
     * @param numRows 生成する行数
     * @return パスカルの三角形を表す2次元リスト
     *
     * 時間計算量: O(n²) - n行 × 各行最大n個の要素
     * 空間計算量: O(n²) - 全ての行を保存（1+2+...+n = n(n+1)/2個の要素）
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // エッジケース：行数が0以下
        if (numRows <= 0) {
            return triangle;
        }

        // 各行を生成
        for (int i = 0; i < numRows; i++) {
            // 新しい行を作成（重要：前の行とは独立した新しいリスト）
            List<Integer> currentRow = new ArrayList<>();

            // Step 1: 最初の要素は必ず1
            currentRow.add(1);

            // Step 2: 中間要素の計算（2行目以降）
            if (i > 0) {
                // 前の行を取得（読み取り専用 - 変更しない）
                List<Integer> previousRow = triangle.get(i - 1);

                // 中間要素を左から右へ計算
                // なぜ左から右でOK？ → previousRowは変更されないから！
                for (int j = 1; j < i; j++) {
                    int leftValue = previousRow.get(j - 1);
                    int rightValue = previousRow.get(j);
                    int sum = leftValue + rightValue;
                    currentRow.add(sum);
                }

                // Step 3: 最後の要素も1
                currentRow.add(1);
            }

            // 完成した行を三角形に追加
            triangle.add(currentRow);
        }

        return triangle;
    }

    /**
     * 右から左へ計算するバージョン（動作確認用）
     * 結果は同じになることを実証
     */
    public List<List<Integer>> generateRightToLeft(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows <= 0) return triangle;

        for (int i = 0; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();

            // 最初にi+1個の要素を0で初期化
            for (int k = 0; k <= i; k++) {
                currentRow.add(0);
            }

            // 両端を1に設定
            currentRow.set(0, 1);
            currentRow.set(i, 1);

            // 中間要素を右から左へ計算
            if (i > 0) {
                List<Integer> previousRow = triangle.get(i - 1);
                // 右から左へ（j = i-1 から 1 まで）
                for (int j = i - 1; j > 0; j--) {
                    int sum = previousRow.get(j - 1) + previousRow.get(j);
                    currentRow.set(j, sum);
                }
            }

            triangle.add(currentRow);
        }

        return triangle;
    }

    /**
     * ===================================================================
     * Problem 119: Pascal's Triangle II
     * 特定の行だけを返す実装（メモリ効率重視）
     * ===================================================================
     */

    /**
     * パスカルの三角形の特定の行だけを生成する（メモリ効率版）
     *
     * 問題：Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.
     * 要求：パスカルの三角形のrowIndex番目の行だけを返す
     * 制約：O(rowIndex)の追加空間だけで実装する
     * 戻り値：List<Integer> （1次元リスト - 1行だけ）
     *
     * アルゴリズムの特徴：
     * - 1つの配列を使い回す（前の行を上書きしていく）
     * - 同じ配列を更新するため、更新順序が重要
     * - 必ず右から左へ更新する必要がある
     *
     * なぜ右から左？
     * - 計算式: row[j] = row[j] + row[j-1]
     * - j-1（左の値）を参照するため、左から更新すると参照値が変わってしまう
     * - 右から更新すれば、左の値はまだ元のまま
     *
     * @param rowIndex 取得したい行のインデックス（0-indexed）
     * @return 指定された行のリスト
     *
     * 時間計算量: O(n²) - n回のループ × 各ループ最大n回の更新
     * 空間計算量: O(n) - 1つの配列のみ使用（メモリ効率的！）
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        // 初期状態：0行目 = [1]
        row.add(1);

        // 1行目からrowIndex行目まで、配列を変形していく
        for (int i = 1; i <= rowIndex; i++) {
            // ★重要★ 右から左へ更新（j = i-1 から 1 まで）
            // なぜ右から？ → 左の値(j-1)を参照するから
            for (int j = i - 1; j > 0; j--) {
                // row[j] = row[j] + row[j-1]
                // 右から処理するので、row[j-1]はまだ元の値
                int currentValue = row.get(j);
                int leftValue = row.get(j - 1);
                row.set(j, currentValue + leftValue);
            }

            // 最後に1を追加（行の右端）
            row.add(1);
        }

        return row;
    }

    /**
     * 【実証】左から更新するとどうなるか（間違った実装）
     * これは教育目的のみ - 実際には使用しないこと！
     */
    public List<Integer> getRowWrongWay(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);

        System.out.println("\n【警告】左から更新する間違った実装の実行");

        for (int i = 1; i <= rowIndex; i++) {
            System.out.println("i=" + i + " 開始: " + row);

            // ★間違い★ 左から右へ更新
            for (int j = 1; j < i; j++) {
                int oldValue = row.get(j);
                int leftValue = row.get(j - 1);
                row.set(j, oldValue + leftValue);
                System.out.println("  j=" + j + ": " + oldValue + "+" + leftValue + "=" + (oldValue + leftValue) + " → " + row);
            }

            row.add(1);
            System.out.println("  最後に1追加: " + row);
        }

        return row;
    }

    /**
     * ===================================================================
     * 別解：数学的アプローチ
     * ===================================================================
     */

    /**
     * 二項係数を使った数学的解法
     * パスカルの三角形の値 = nCr（組み合わせ）
     *
     * 利点：配列の更新が不要
     * 欠点：大きな数での整数オーバーフローに注意
     */
    public List<Integer> getRowMathematical(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            // C(n, r) = n! / (r! * (n-r)!)
            // 効率的な計算: C(n, r) = C(n, r-1) * (n-r+1) / r
            long value = 1;
            for (int j = 0; j < i; j++) {
                value = value * (rowIndex - j) / (j + 1);
            }
            row.add((int) value);
        }

        return row;
    }

    /**
     * ===================================================================
     * テストと実証
     * ===================================================================
     */

    /**
     * 2つの実装方法の違いを実証する
     */
    public void demonstrateDifference() {
        System.out.println("================================================");
        System.out.println("Problem 118 vs Problem 119 の違い");
        System.out.println("================================================\n");

        System.out.println("【Problem 118: 全ての行を返す】");
        System.out.println("要求: List<List<Integer>> - 2次元リスト");
        System.out.println("例: numRows=4");
        List<List<Integer>> allRows = generate(4);
        System.out.println("結果: " + allRows);
        System.out.println("メモリ: 4つの配列、計10個の要素\n");

        System.out.println("【Problem 119: 特定の行だけを返す】");
        System.out.println("要求: List<Integer> - 1次元リスト");
        System.out.println("制約: O(n)空間で実装");
        System.out.println("例: rowIndex=3");
        List<Integer> singleRow = getRow(3);
        System.out.println("結果: " + singleRow);
        System.out.println("メモリ: 1つの配列、最大4個の要素\n");
    }

    /**
     * 更新順序の重要性を実証
     */
    public void demonstrateUpdateOrder() {
        System.out.println("================================================");
        System.out.println("更新順序の重要性（rowIndex=3の例）");
        System.out.println("================================================\n");

        System.out.println("【正しい実装（右から左）】");
        List<Integer> correct = getRow(3);
        System.out.println("結果: " + correct + " ✅\n");

        System.out.println("【間違った実装（左から右）】");
        List<Integer> wrong = getRowWrongWay(3);
        System.out.println("結果: " + wrong + " ❌");
        System.out.println("正解は[1,3,3,1]なのに[1,3,4,1]になってしまった！");
    }

    /**
     * パフォーマンス比較
     */
    public void comparePerformance() {
        System.out.println("\n================================================");
        System.out.println("パフォーマンス比較（30行目を取得）");
        System.out.println("================================================\n");

        // 方法1: 全ての行を生成
        long start1 = System.nanoTime();
        List<List<Integer>> all = generate(31);
        List<Integer> row1 = all.get(30);
        long end1 = System.nanoTime();

        // 方法2: 特定の行だけ生成
        long start2 = System.nanoTime();
        List<Integer> row2 = getRow(30);
        long end2 = System.nanoTime();

        // 方法3: 数学的解法
        long start3 = System.nanoTime();
        List<Integer> row3 = getRowMathematical(30);
        long end3 = System.nanoTime();

        System.out.println("全ての行を生成: " + (end1-start1)/1000000.0 + " ms");
        System.out.println("  メモリ使用: " + (31*32/2) + "個の要素");
        System.out.println("1つの行だけ生成: " + (end2-start2)/1000000.0 + " ms");
        System.out.println("  メモリ使用: 31個の要素のみ");
        System.out.println("数学的解法: " + (end3-start3)/1000000.0 + " ms");
        System.out.println("  メモリ使用: 31個の要素のみ");
    }

    /**
     * メイン実行
     */
    public static void main(String[] args) {
        PascalTriangle_Complete solution = new PascalTriangle_Complete();

        System.out.println("========================================");
        System.out.println("   パスカルの三角形 - 完全版");
        System.out.println("========================================\n");

        // 1. 2つの問題の違いを実証
        solution.demonstrateDifference();

        // 2. 更新順序の重要性を実証
        solution.demonstrateUpdateOrder();

        // 3. パフォーマンス比較
        solution.comparePerformance();

        // 4. 左右どちらでも同じ結果になることを確認（Problem 118）
        System.out.println("\n================================================");
        System.out.println("Problem 118での更新順序の確認");
        System.out.println("================================================\n");

        List<List<Integer>> leftToRight = solution.generate(5);
        List<List<Integer>> rightToLeft = solution.generateRightToLeft(5);

        System.out.println("左から右: " + leftToRight);
        System.out.println("右から左: " + rightToLeft);
        System.out.println("結果: " + (leftToRight.equals(rightToLeft) ? "同じ！✅" : "違う❌"));
    }
}