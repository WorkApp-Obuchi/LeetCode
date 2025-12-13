/*
 * TreeNodeクラス
 * 二分木のノードを表す最小限の共通クラス
 * val:ノードの値
 * left:左の子ノード
 * right:右の子ノード
 * 二分木の反転と探索問題などの共通して使用できる
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { 
        this.val = val; 
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
