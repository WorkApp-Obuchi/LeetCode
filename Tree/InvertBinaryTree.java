package LeetCode.Tree;

import java.util.*;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // 左右の子を入れ替え
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 再起的に子ノードも反転
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static String treeToString(TreeNode root) {
        if (root == null) return "[]";

        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                result.add("null");
            }
        }
        // 末尾のnullを削除
        while (result.size() > 0 && result.get(result.size() - 1).equals("null")) {
            result.remove(result.size() - 1);
        }
        return result.toString();
    }


    public static void main(String[] args) {

        InvertBinaryTree solution = new InvertBinaryTree();

        // testcase1
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode result1 = solution.invertTree(root);
        System.out.println("testcase1 :" + treeToString(result1));
        ;

        // testcase2
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        TreeNode result2 = solution.invertTree(root2);
        System.out.println("testcase2 :" + treeToString(result2));

        // testcase3
        TreeNode root3 = null;
        TreeNode result3 = solution.invertTree(root3);
        System.out.println("testcase3 :" + treeToString(result3));

    }
}
