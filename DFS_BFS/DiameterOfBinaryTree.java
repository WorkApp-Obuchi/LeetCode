import common.ArrayToTree;
import common.TreeNode;
/*
 * 543. Diameter of Binary Tree
 * 二分木の直径を求めるメソッド
 * 直径は木の任意の２ノード間の最長パスの長さで定義される
 */
public class DiameterOfBinaryTree {
    private int diameter = 0;
    /*
    * 二分木の直径の計算をする
    * @param root 二分木の根のノード
    * @return 木の直径
    */
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root); //深さ計算
        return diameter; //最終ていな直径を返す
    }
    /*
    * 指定されたノードを根とする部分木の深さを計算する
    * @param node 現在のノード
    * @return nodeを根とする部分木の長さ
    */
    private int depth(TreeNode node){
        if(node == null) return 0 ;
        //左の深さ
        int left = depth(node.left);
        //右の深さ
        int right = depth(node.right);
        //このノードを通る最長パス(直径候補)
        diameter = Math.max(diameter, left + right);
        //このノードの深さを返す(親ノードが利用する)
        return Math.max(left, right) + 1;
    }
    //実行用main
    public static void main(String[] args) {

        // ---- Example 1 ----
        // Input: [1,2,3,4,5]
        Integer[] arr1 = {1, 2, 3, 4, 5};
        TreeNode root1 = ArrayToTree.arrayToTree(arr1);

        DiameterOfBinaryTree sol = new DiameterOfBinaryTree();
        int ans1 = sol.diameterOfBinaryTree(root1);
        System.out.println("Example 1 Output: " + ans1); // 3

        // ---- Example 2 ----
        // Input: [1,2]
        Integer[] arr2 = {1, 2};
        TreeNode root2 = ArrayToTree.arrayToTree(arr2);

        int ans2 = sol.diameterOfBinaryTree(root2);
        System.out.println("Example 2 Output: " + ans2); // 1
    }
}
