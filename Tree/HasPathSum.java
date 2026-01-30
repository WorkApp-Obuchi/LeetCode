package LeetCode.Tree;

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        // 葉ノードの場合
        if(root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // 葉ノードではない場合
        int remaining = targetSum - root.val;
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }

    public static void main(String[] args) {
        /*
         * 木の構造:
         *         5
         *        / \
         *       4   8
         *      /   / \
         *     11  13  4
         *    /  \      \
         *   7    2      1
         */

        // ボトムアップで構築（葉ノードから）
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);

        TreeNode node11 = new TreeNode(11, node7, node2);
        TreeNode node13 = new TreeNode(13);
        TreeNode node4Right = new TreeNode(4, null, node1);

        TreeNode node4Left = new TreeNode(4, node11, null);
        TreeNode node8 = new TreeNode(8, node13, node4Right);

        TreeNode root = new TreeNode(5, node4Left, node8);

        // 確認用: Path Sum テスト
        System.out.println("=== Path Sum Test ===");

        HasPathSum solution = new HasPathSum();
        System.out.println("testcase1 : " + solution.hasPathSum(root, 22));

        /*
         * 木の構造:
         *     1
         *    / \
         *   2   3
         */

        TreeNode node22 = new TreeNode(2);
        TreeNode node23 = new TreeNode(3);
        TreeNode root2 = new TreeNode(1, node22, node23);
        System.out.println("testcase2 : " + solution.hasPathSum(root2, 5));

        TreeNode root3 = null;
        System.out.println("testcase3 : " + solution.hasPathSum(root3, 0));

    }
}
