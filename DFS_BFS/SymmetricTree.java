import common.ArrayToTree;
import common.TreeNode;

/*
 * 101. Symmetric Tree
 * 二つのノードが鏡像かどうかを再帰的に判断する。
 * @param left 左側のノード
 * @param right 右側のノード
 * @return 左右対称 true 左右非対称 false
 */
public class SymmetricTree {
  public boolean isSymmetric(TreeNode root) {
        //空なら左右対称とみなす
        if(root == null) return true ;
        //左右の部分木が鏡かどうかを再帰で判定
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left,TreeNode right){
        //両方のノードがnullの場合は左右対称
        if(left == null && right == null) return true;
        //片方だけnullの場合は左右非対称
        if(left == null || right == null) return false;
        //値が異なる場合は左右非対称
        if(left.val != right.val) return false;
        //左右の子ノードを再帰的に比較する。
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

     public static void main(String[] args) {
        SymmetricTree sol = new SymmetricTree();

        // Example 1
        Integer[] arr1 = {1,2,2,3,4,4,3};
        TreeNode root1 = ArrayToTree.arrayToTree(arr1);
        System.out.println("Example 1 Output: " + sol.isSymmetric(root1)); // true

        // Example 2
        Integer[] arr2 = {1,2,2,null,3,null,3};
        TreeNode root2 = ArrayToTree.arrayToTree(arr2);
        System.out.println("Example 2 Output: " + sol.isSymmetric(root2)); // false
    }

}
