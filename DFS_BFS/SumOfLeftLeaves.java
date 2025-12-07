import common.ArrayToTree;
import common.TreeNode;
/*
 * 404. Sum of Left Leaves
 * 二分木において、左葉の合計を求める。
 * @param root 現在ノード
 * @return 現在の部分木にある左葉の合計
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0 ;//ノードがnullなら合計０
        int sum = 0;//左葉の合計を保持する変数

        //左の子が存在し、かつその左の子、右の子がnullなら左葉
        if(root.left != null && root.left.left == null && root.left.right == null){
            sum += root.left.val; //左葉の値を合計に加える
        }

        //左部分木の左葉の合計を再帰的に加算
        sum += sumOfLeftLeaves(root.left);
        //右部分の右葉の合計を再帰的に加算
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
    //実行用のmain
    public static void main(String[] args) {
        SumOfLeftLeaves solver = new SumOfLeftLeaves();

        // ---- Example 1 ----
        Integer[] arr1 = {3, 9, 20, null, null, 15, 7};
        TreeNode root1 = ArrayToTree.arrayToTree(arr1);
        int ans1 = solver.sumOfLeftLeaves(root1);
        System.out.println("Example 1 Output: " + ans1); // Output: 24

        // ---- Example 2 ----
        Integer[] arr2 = {1};
        TreeNode root2 = ArrayToTree.arrayToTree(arr2);
        int ans2 = solver.sumOfLeftLeaves(root2);
        System.out.println("Example 2 Output: " + ans2); // Output: 0
    }
}
