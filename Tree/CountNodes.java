package LeetCode.Tree;

/**
 * LeetCode 222. Count Complete Tree Nodes
 *
 * 完全二分木のノード数をカウントする問題
 *
 * 完全二分木の定義：
 * - 最下層以外のすべての層が完全に埋まっている
 * - 最下層のノードは左から順に詰められている
 *
 * 時間計算量: O(log²n)
 * - 深さの計算: O(log n)
 * - 再帰の回数: O(log n)
 *
 * 空間計算量: O(log n)
 * - 再帰のスタック深さ
 */
public class CountNodes {

    /**
     * 完全二分木のノード数をカウントする
     *
     * アルゴリズムの考え方：
     * 1. 左端と右端の深さを比較
     * 2. 深さが同じ → 満杯の完全二分木 → 2^depth - 1 で即座に計算
     * 3. 深さが異なる → 左右のサブツリーを再帰的にカウント
     *
     * @param root 二分木のルートノード
     * @return ノードの総数
     */
    public int countNodes(TreeNode root) {
        // ベースケース：空の木
        if (root == null) return 0;

        // 左端と右端の深さを取得
        int leftDepth = getLeftDepth(root);
        int rightDepth = getRightDepth(root);

        if (leftDepth == rightDepth) {
            // 深さが同じ = 完全に埋まった木
            // ノード数 = 2^depth - 1
            // ビットシフトで計算: 1 << depth = 2^depth
            return (1 << leftDepth) - 1;
        } else {
            // 深さが異なる = 最下層が完全には埋まっていない
            // 1(現在のノード) + 左サブツリー + 右サブツリー
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    /**
     * 左端を辿って深さを取得
     *
     * @param node 開始ノード
     * @return 左端の深さ
     */
    private int getLeftDepth(TreeNode node) {
        int depth = 0;

        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

    /**
     * 右端を辿って深さを取得
     *
     * @param node 開始ノード
     * @return 右端の深さ
     */
    private int getRightDepth(TreeNode node) {
        int depth = 0;

        while (node != null) {
            depth++;
            node = node.right;
        }
        return depth;
    }

    public static void main(String[] args) {

        // ========================================
        // testcase1: root = [1,2,3,4,5,6]
        // 期待値: 6
        // ========================================
        //        1
        //       / \
        //      2   3
        //     / \ /
        //    4  5 6
        // ========================================
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;

        // ========================================
        // testcase2: root = []
        // 期待値: 0
        // ========================================
        TreeNode root2 = null;

        // ========================================
        // testcase3: root = [1]
        // 期待値: 1
        // ========================================
        TreeNode root3 = new TreeNode(1);

        // 実行
        CountNodes solution = new CountNodes();
        int result = solution.countNodes(root);
        int result2 = solution.countNodes(root2);
        int result3 = solution.countNodes(root3);

        // 結果出力
        System.out.println("testcase1 : " + result);   // 6
        System.out.println("testcase2 : " + result2);  // 0
        System.out.println("testcase3 : " + result3);  // 1
    }
}