package common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeUtils {
    /**
     * BST をレベル順で配列に変換する
     * null は "null" として出力
     */
    public static List<String> toLevelOrderArray(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                result.add(String.valueOf(node.val));
                q.offer(node.left);
                q.offer(node.right);
            } else {
                result.add("null");
            }
        }

        // 末尾の null は不要
        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            result.remove(i);
            i--;
        }

        return result;
    }
}
