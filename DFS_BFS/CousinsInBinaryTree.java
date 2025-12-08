import common.ArrayToTree;
import common.TreeNode;
/*
 * 993. Cousins in Binary Tree
 * 二分木の直径を求めるメソッド
 * 二分木のノード x と y が「いとこ(cousins)」かを判定するクラス
 * いとこ条件は、深さが同じで親が異なる
 */
public class CousinsInBinaryTree {
    private TreeNode xParent = null ; //xの親ノードを覚える変数
    private TreeNode yParent = null ; //yの親ノードを覚える変数
    private int xDepth = -1 ; //xノードの深さ
    private int yDepth = -1 ; //yノードの深さ
    /*
     * x と y がいとこか判断
     * @param root 木の根ノード
     * @param x 判定対象のノードx
     * @param y 判定対象のノードy
     * @return x と y　がいとこならtrue 出なければfalse
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        //node=現在のノード, parent=親ノード, depth=現在の深さ, x,y=判定対象
        dfs(root, null, 0, x, y);
        //判定: 深さが同じ && 親が違う → いとこ
        return xDepth == yDepth && xParent != yParent;
    }
    /*
     * @param node 現在探索中のノード
     * @param parent node の親ノード
     * @param depth 根からの深さ
     * @param x 判定対象のノード値 x
     * @param y 判定対象のノード値 y
     */
    private void dfs(TreeNode node, TreeNode parent, int depth, int x, int y){
        if(node == null) return; //処理を止める

        if(node.val == x){
            xParent = parent; //xの親ノードを記録
            xDepth = depth; //xの深さを記録
        }
        if(node.val == y){
            yParent = parent; //yの親ノードを記録
            yDepth = depth; //yの深さを記録
        }
        dfs(node.left, node, depth + 1, x, y); // node が左の子にとっての親になる
        dfs(node.right, node, depth + 1, x, y); // node が右の子にとっての親になる
    }
  //実行用のmain
    public static void main(String[] args) {
        CousinsInBinaryTree checker = new CousinsInBinaryTree();

        // ---- Example 1 ----
        Integer[] arr1 = {1,2,3,4};
        TreeNode root1 = ArrayToTree.arrayToTree(arr1);
        int x1 = 4, y1 = 3;
        boolean ans1 = checker.isCousins(root1, x1, y1);
        System.out.println("Example 1: " + ans1); // false

        // ---- Example 2 ----
        Integer[] arr2 = {1,2,3,null,4,null,5};
        TreeNode root2 = ArrayToTree.arrayToTree(arr2);
        int x2 = 5, y2 = 4;
        boolean ans2 = checker.isCousins(root2, x2, y2);
        System.out.println("Example 2: " + ans2); // true

        // ---- Example 3 ----
        Integer[] arr3 = {1,2,3,null,4};
        TreeNode root3 = ArrayToTree.arrayToTree(arr3);
        int x3 = 2, y3 = 3;
        boolean ans3 = checker.isCousins(root3, x3, y3);
        System.out.println("Example 3: " + ans3); // false
    }
}
