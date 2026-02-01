package LeetCode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        int sum = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                // 左の子が葉ノードの場合
                sum += root.left.val;
            } else {
                // 左の子が葉ノードでない場合、再帰で探索を続ける
                sum += sumOfLeftLeaves(root.left);
            }
        }
        // 右の子の処理
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }

    public static void main(String[] args) {

        SumOfLeftLeaves solution = new SumOfLeftLeaves();

        // testcase1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.left.left = null;
        root.left.right = null;

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result1 = solution.sumOfLeftLeaves(root);
        System.out.println("testcase1 :" + result1);
        ;

        // testcase2
        TreeNode root2 = new TreeNode(1);

        int result2 = solution.sumOfLeftLeaves(root2);
        System.out.println("testcase2 :" + result2);

    }
}
