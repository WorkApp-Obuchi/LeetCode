import common.ArrayToTree;
import common.TreeNode;
/*
 * 104. Maximum Depth of Binary Tree
 * 二分木の最小深さを求める
 * @param root 二分木の根のノード
 * @return 最小深さ（葉ノードまでの段数）
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) return 0 ;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        //片方がnullの場合はnullを最小の深さに使ってはいけない
        if(root.left == null) return right + 1 ;
        if(root.right == null) return left + 1 ;

        return Math.min(left,right) + 1;
    }
    public static void main(String[] args) {

        // ---- Example 1 ----
        Integer[] arr1 = {3, 9, 20, null, null, 15, 7};
        TreeNode root1 = ArrayToTree.arrayToTree(arr1);

        MinimumDepthOfBinaryTree minDepth = new MinimumDepthOfBinaryTree();
        int ans1 = minDepth.minDepth(root1);
        System.out.println("Example 1 Output: " + ans1); //Output:2

        // ---- Example 2 ----
        Integer[] arr2 = {2, null, 3, null, 4, null, 5, null, 6};
        TreeNode root2 = ArrayToTree.arrayToTree(arr2);

        int ans2 = minDepth.minDepth(root2);
        System.out.println("Example 2 Output: " + ans2); //Output:5
    }
}
