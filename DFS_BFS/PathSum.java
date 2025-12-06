import common.ArrayToTree;
import common.TreeNode;
/*
 * 112. Path Sum
 * 二分木において、ルートから葉までのパスの合計が targetSum に一致するかを判定する。
 * @param root 二分木の根のノード
 * @param targetSum 探したいパスの合計値
 * @return パスが存在すれば true　なければ false
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //空の場合はパスがないのでfalse
        if(root == null) return false;
        //葉まで到達して合計がtargetSumと一致すればtrue
        if(root.left == null && root.right == null){
            return targetSum == root.val;
        }
        //左右どっちかの子でパスがあればtrue
        //左右ともに存在なしfalse
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right,targetSum - root.val);
    }
        public static void main(String[] args) {
        PathSum ps = new PathSum();

        // Example 1
        Integer[] arr1 = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root1 = ArrayToTree.arrayToTree(arr1);
        System.out.println(ps.hasPathSum(root1, 22)); // true

        // Example 2
        Integer[] arr2 = {1,2,3};
        TreeNode root2 = ArrayToTree.arrayToTree(arr2);
        System.out.println(ps.hasPathSum(root2, 5)); // false

        // Example 3
        Integer[] arr3 = {};
        TreeNode root3 = ArrayToTree.arrayToTree(arr3);
        System.out.println(ps.hasPathSum(root3, 0)); // false
    }
}
