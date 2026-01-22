package LeetCode.Tree;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        // ①base case
        if(root == null) return true;

        // どこか1つでもノードが次の条件を満たさない場合、その木はバランスが取れていない。
        //
        //条件
        //あるノードについて
        //左部分木の高さ − 右部分木の高さ の絶対値が 1 を超える（≥ 2）

        // ② 左右の高さを取得
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // ③ 高さの差が2以上ならアンバランス
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        // ④ 左右の部分木もチェック
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode node) {
            if(node == null) return 0;

            // 下方向に再帰している
            return 1 + Math.max(getHeight(node.left) , getHeight(node.right));
    }

    public static void main(String[] args) {
        BalancedBinaryTree solution = new BalancedBinaryTree();

        // testcase1
        // 入力: root = [3,9,20,null,null,15,7]
        // 出力: true
        TreeNode node1 =
                new TreeNode(3,
                        new TreeNode(9),
                        new TreeNode(20,
                                new TreeNode(15),
                                new TreeNode(7)
                        )
                );

       System.out.println("testcase1 : " + solution.isBalanced(node1));

        // testcase2
        // 入力: root = [1,2,2,3,3,null,null,4,4]
        // 出力: false
        TreeNode node2 = new TreeNode(1,
                            new TreeNode(2),
                            new TreeNode(2,
                                    new TreeNode(3),
                                    new TreeNode(3,
                                            new TreeNode(4),
                                            new TreeNode(4)
                                    )
                            )
        );

        System.out.println("testcase2 : " + solution.isBalanced(node2));

        // testcase3
        // 入力: root = []
        // 出力: true
        TreeNode node3 = null;

        System.out.println("testcase3 : " + solution.isBalanced(node3));

    }

}
