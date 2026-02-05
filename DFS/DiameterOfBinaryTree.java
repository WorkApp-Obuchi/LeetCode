package LeetCode.DFS;

public class DiameterOfBinaryTree {
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }
    private int depth(TreeNode node) {
        if(node == null) return 0;

        int leftDiameter = depth(node.left);
        int rightDiameter = depth(node.right);

        // このノードを頂点とする直径を計算
        maxDiameter = Math.max(maxDiameter, leftDiameter + rightDiameter);

        // 深さを返す
        return Math.max(leftDiameter, rightDiameter) + 1;
    }
}
