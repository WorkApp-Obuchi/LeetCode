package LeetCode.Tree;

public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    public static void main(String[] args) {

        RangeSumBST solution = new RangeSumBST();

        // testcase1
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(15);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(7);
        // root1.right.left = null (省略)
        root1.right.right = new TreeNode(18);

        int result = solution.rangeSumBST(root1, 7, 15);
        System.out.println("testcase1: low = 7, high = 15 →　" + result);

        // testcase2
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(13);
        root2.right.right = new TreeNode(18);
        root2.left.left.left = new TreeNode(1);
        // root2.left.left.right = null (省略)
        root2.left.right.left = new TreeNode(6);

        int result2 = solution.rangeSumBST(root2, 6, 10);
        System.out.println("testcase2: low = 6, high = 10 →　" + result2);
    }
}
