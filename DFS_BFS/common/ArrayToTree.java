package common;

import java.util.LinkedList;
import java.util.Queue;

/*
 * ArrayToTree
 * 配列から二分木(TreeNode)を生成するクラス
*/

public class ArrayToTree {
    // 配列から TreeNode を作成（null は子なし）
    public static TreeNode arrayToTree(Integer[] arr) {
      // 空配列の場合は null を返す
        if (arr.length == 0) return null;
        // 配列の最初の要素をルートに設定
        TreeNode root = new TreeNode(arr[0]);
        // BFS 用のキュー
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        // キューが空でない限り、または配列に要素が残っている限り処理
        while (!queue.isEmpty() && i < arr.length) { // 安全対策
            TreeNode current = queue.poll();
            if (current == null) continue;
            // 左子を作成
            if (arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;
            // 右子を作成（配列境界チェック）
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }
}