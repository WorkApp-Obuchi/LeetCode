import java.util.*;
  /*
   * 104. Maximum Depth of Binary Tree
   * 二分探索木(BST)の最大深さを求める問題
   *
   * @param 昇順のソートされたリスト
   * @retrun 重複のないリスト
   */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0; //nullは深さ０を返す。

        int left = maxDepth(root.left); //左側の最大深さを正数で返す
        int right = maxDepth(root.right); //右側の最大深さを正数で返す。

        return Math.max(left,right) + 1; //+1は親の数
    }
    //以下テスト用に作成
    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            // left child
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            // right child
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

        public static void main(String[] args) {
        MaximumDepthofBinaryTree sol = new MaximumDepthofBinaryTree();

        // Example 1
        Integer[] ex1 = {3, 9, 20, null, null, 15, 7};
        TreeNode root1 = buildTree(ex1);
        System.out.println("Example 1: " + sol.maxDepth(root1)); // → 3

        // Example 2
        Integer[] ex2 = {1, null, 2};
        TreeNode root2 = buildTree(ex2);
        System.out.println("Example 2: " + sol.maxDepth(root2)); // → 2
    }
}