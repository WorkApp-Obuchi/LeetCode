package common;
/*
 * TreeNodeクラス
 * 二分木のノードを表す最小限の共通クラス
 * val:ノードの値
 * left:左の子ノード
 * right:右の子ノード
 * 二分木の反転と探索問題などの共通して使用できる
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    /*
     * 値を指定してノードを作成
     * @param x:ノードの値
     */
    public TreeNode(int x) {
        val = x;
    }
}
