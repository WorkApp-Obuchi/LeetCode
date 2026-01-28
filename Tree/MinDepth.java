package LeetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if(node.left == null && node.right == null) {
                    return depth;
                }
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        MinDepth solution = new MinDepth();

        // testcase1
        // 各ノードを作成
        TreeNode node1 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        // ノード同士をつなげる
        node1.left = node9;
        node1.right = node20;
        node20.left = node15;
        node20.right = node7;

        System.out.println("testcase1 : " + solution.minDepth(node1));

        // testcase2
        // 各ノードを作成
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        // 右だけつなげていく
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
        node5.right = node6;

        System.out.println("testcase2 : " + solution.minDepth(node2));
    }
}
