package LeetCode.Tree;

public class ReReBalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode node) {
        if(node == null) return 0;

        int left = getHeight(node.left);
        if(left == -1) return -1;

        int right = getHeight(node.right);
        if(right == -1) return -1;

        if(Math.abs(left - right) > 1) return -1;


        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        ReReBalancedBinaryTree solution = new ReReBalancedBinaryTree();

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
