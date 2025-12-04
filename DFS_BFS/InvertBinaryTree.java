import common.ArrayToTree;
import common.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
 * 226. Invert Binary Tree
 * 二分木を左右反転させる（mirror image を作る）問題
 * @param root 反転させたい二分木のルートノード（TreeNode型）
 *             nullの場合はnullを返す
 * @return 左右反転させた二分木のルートノード
 */

public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        //rootがnullの時は処理はしない
        if(root == null) return null;
        //左右を入れ替える
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //左の部分を反転させる
        invertTree(root.left);
        //右の部分を反転させる
        invertTree(root.right);
        //反転させたrootを返す
        return root;
    }

    // 木をレベル順で出力（ArrayListで表す）
    public static List<Integer> treeToList(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      if (root == null) return result;

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
          TreeNode node = queue.poll();
          if (node != null) {
              result.add(node.val);
              queue.offer(node.left);
              queue.offer(node.right);
          }
        }
        return result;
    }

    //実行用main
    public static void main(String[] args) {
      // 例 1
      Integer[] arr1 = {4,2,7,1,3,6,9};
      TreeNode root1 = ArrayToTree.arrayToTree(arr1);
      invertTree(root1);
      System.out.println(treeToList(root1)); // [4,7,2,9,6,3,1]

      // 例 2
      Integer[] arr2 = {2,1,3};
      TreeNode root2 = ArrayToTree.arrayToTree(arr2);
      invertTree(root2);
      System.out.println(treeToList(root2)); // [2,3,1]

      // 例 3
      Integer[] arr3 = {};
      TreeNode root3 = ArrayToTree.arrayToTree(arr3);
      invertTree(root3);
      System.out.println(treeToList(root3)); // []
    }
}
