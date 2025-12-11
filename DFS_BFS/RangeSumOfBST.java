import common.ArrayToTree;
import common.TreeNode;
/*
 * 938. Range Sum of BST
 * BST の中から、[low, high] の範囲に含まれるノードの値の合計を求める。
 * BST の性質（左 < 親 < 右）を利用して、不要なサブツリーは再帰しない
 * 
 * @param node BST の根ノード
 * @param low 範囲の下限
 * @param high 範囲の上限
 * @return 範囲内にあるノード
 */
public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0 ;
        //範囲より下→右だけ
        if(root.val < low){
            return rangeSumBST(root.right, low, high);
        }
        //範囲より上→左だけ
        if(root.val > high){
            return rangeSumBST(root.left, low,high);
        }
        //範囲内　自分＋左＋右
        return root.val + rangeSumBST(root.left, low,high) + rangeSumBST(root.right, low, high);
    }
    //実行用のmain
    public static void main(String[] args) {

        RangeSumOfBST sol = new RangeSumOfBST();

        // ---- Example 1 ----
        Integer[] arr1 = {10, 5, 15, 3, 7, null, 18};
        TreeNode root1 = ArrayToTree.arrayToTree(arr1);
        int low1 = 7;
        int high1 = 15;

        int ans1 = sol.rangeSumBST(root1, low1, high1);
        System.out.println("Example 1 Output: " + ans1); // 32


        // ---- Example 2 ----
        Integer[] arr2 = {10, 5, 15, 3, 7, 13, 18, 1, null, 6};
        TreeNode root2 = ArrayToTree.arrayToTree(arr2);
        int low2 = 6;
        int high2 = 10;

        int ans2 = sol.rangeSumBST(root2, low2, high2);
        System.out.println("Example 2 Output: " + ans2); // 23
    }
}
