package LeetCode.Tree;

public class IsCousins {
        int xDepth, yDepth;
        TreeNode xParent, yParent;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;

        // DFS で探索（root の親は null、深さは 0）
        dfs(root, null, 0, x, y);

        return xDepth == yDepth && xParent != yParent;
    }
    private void dfs(TreeNode node, TreeNode parent, int depth, int x, int y) {
        if(node == null) return;

        // xを見つけたら記録
        if(node.val == x) {
            xDepth = depth;
            xParent = parent;
        }

        // yを見つけたら記録
        if(node.val == y) {
            yDepth = depth;
            yParent = parent;
        }
        // 左右の子を探索（親は現在のnode、深さは+1）
        dfs(node.left, node, depth + 1, x, y);
        dfs(node.right, node, depth + 1, x, y);
    }

    public static void main(String[] args) {
        IsCousins solution = new IsCousins();

        // testcase1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);

        System.out.println("testcase1 : " + solution.isCousins(root1, 4,3)); // false

        // testcase2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(5);

        System.out.println("testcase2 : " + solution.isCousins(root2, 5, 4)); // true

        // testcase3
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        root3.left.right = new TreeNode(4);

        System.out.println("testcase3 : " + solution.isCousins(root3, 2,3)); // false


    }
}
