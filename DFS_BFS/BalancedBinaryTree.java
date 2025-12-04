import common.ArrayToTree;
import common.TreeNode;

public class BalancedBinaryTree {
  public boolean isBalanced(TreeNode root) {
        //height()が-1ならアンバランス
        return height(root) != -1 ;
    }
    private int height(TreeNode node){
        if(node == null) return 0; //空ノードは高さ０
        //左部分木の高さを再帰処理的に取得
        int left = height(node.left);
        //右部分木の高さを再帰処理的に取得
        int right = height(node.right);
        //左右どちらかがアンバランスなら自分もアンバランス
        //また、左右の高さが2以上ならアンバランス
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        //左右の高さの大きい方+1 を自分の高さとして返す
        return Math.max(left,right) + 1;
    }

  public static void main(String[] args) {
        BalancedBinaryTree solution = new BalancedBinaryTree();

        // 例 1: [3,9,20,null,null,15,7]
        Integer[] arr1 = {3,9,20,null,null,15,7};
        TreeNode root1 = ArrayToTree.arrayToTree(arr1);
        System.out.println("Example 1: " + solution.isBalanced(root1)); // true

        // 例 2: [1,2,2,3,3,null,null,4,4]
        Integer[] arr2 = {1,2,2,3,3,null,null,4,4};
        TreeNode root2 = ArrayToTree.arrayToTree(arr2);
        System.out.println("Example 2: " + solution.isBalanced(root2)); // false

        // 例 3: []
        Integer[] arr3 = {};
        TreeNode root3 = ArrayToTree.arrayToTree(arr3);
        System.out.println("Example 3: " + solution.isBalanced(root3)); // true
    } 
}
