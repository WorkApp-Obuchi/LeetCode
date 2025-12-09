import common.ArrayToTree;
import common.TreeNode;
/*
 * 222. Count Complete Tree Nodes
 * 完全二分木のノード数を効率的にカウントするクラス
 * @param root 完全二分木の根ノード
 * @return ノードの総数
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
      //空の木の場合は0
      if(root == null) return 0 ;
      //左右部分木のノード数を再帰的に計算
      int left = countNodes(root.left);
      int right = countNodes(root.right);
      //現在ノードを足して合計を返す
      return left + right + 1;
    }
   public static void main(String[] args) {

        CountCompleteTreeNodes counter = new CountCompleteTreeNodes();

        // ---- Example 1 ----
        Integer[] arr1 = {1,2,3,4,5,6};
        TreeNode root1 = ArrayToTree.arrayToTree(arr1);
        System.out.println("Example 1 Output: " + counter.countNodes(root1)); // 6

        // ---- Example 2 ----
        Integer[] arr2 = {};
        TreeNode root2 = ArrayToTree.arrayToTree(arr2);
        System.out.println("Example 2 Output: " + counter.countNodes(root2)); // 0

        // ---- Example 3 ----
        Integer[] arr3 = {1};
        TreeNode root3 = ArrayToTree.arrayToTree(arr3);
        System.out.println("Example 3 Output: " + counter.countNodes(root3)); // 1
   }
}