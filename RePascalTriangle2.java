package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class RePascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        // 1行目
        row.add(1);

        for(int i = 1; i < rowIndex; i++) {
            for(int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            // 最後
            row.add(1);
        }
    return row;
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
