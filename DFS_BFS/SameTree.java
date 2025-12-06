import common.ArrayToTree;
import common.TreeNode;

/*
 * 100. Same Tree
 * 二つの二分木が完全に同じ構造・値かを判断する。
 * @param p 一つ目の二分木の根ノード
 * @param q 一つ目の二分木の根ノード
 * @return 木が同じ場合 true 異なる false
 */

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //両方ともnullの場合は同じ木とみなす
        if(p == null && q == null) return true;
        //片方だけnullの場合は木の形が違う
        if(p == null || q == null) return false;
        //値が違う場合は木の形が違う
        if(p.val != q.val) return false;
        //左右の子ノードを再帰的に比較する。
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    public static void main(String[] args) {
        SameTree sol = new SameTree();

        // Example 1
        Integer[] arr1_p = {1,2,3};
        Integer[] arr1_q = {1,2,3};
        TreeNode p1 = ArrayToTree.arrayToTree(arr1_p);
        TreeNode q1 = ArrayToTree.arrayToTree(arr1_q);
        System.out.println("Example 1 Output: " + sol.isSameTree(p1, q1)); // true

        // Example 2
        Integer[] arr2_p = {1,2};
        Integer[] arr2_q = {1,null,2};
        TreeNode p2 = ArrayToTree.arrayToTree(arr2_p);
        TreeNode q2 = ArrayToTree.arrayToTree(arr2_q);
        System.out.println("Example 2 Output: " + sol.isSameTree(p2, q2)); // false

        // Example 3
        Integer[] arr3_p = {1,2,1};
        Integer[] arr3_q = {1,1,2};
        TreeNode p3 = ArrayToTree.arrayToTree(arr3_p);
        TreeNode q3 = ArrayToTree.arrayToTree(arr3_q);
        System.out.println("Example 3 Output: " + sol.isSameTree(p3, q3)); // false
    }
}
