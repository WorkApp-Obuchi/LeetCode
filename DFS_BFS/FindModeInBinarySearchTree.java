import common.ArrayToTree;
import common.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * 501. Find Mode in Binary Search Tree
 * 二分探索木の中で「最も出現回数の多い値」を返す。
 * BST なので中順走査を行うと
 * 値が昇順に並ぶ性質を利用して効率的にカウントできる。
 */
public class FindModeInBinarySearchTree {
    Integer prev = null; //前に見た値
    int count = 0 ; //現在見ている値の出現回数
    int maxCount = 0; //最大出現回数
    List<Integer> modes = new ArrayList<>(); //最頻値を格納するリスト
/*
 * BST　うちの最頻値を求める
 * @param root 二分探索木の根ノード
 * @return 最を出現する値を全て含む配列
 */
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0]; //空の場合は空配列
        inorder(root);
        //List → 配列に変換
        int[] result = new int[modes.size()];
        for(int i = 0;i < modes.size(); i++){
            result[i] = modes.get(i);
        }
        return result;
    }
/*
 * 中順走査を行いつつ、値の出現回数を数える。
 * BST では inorder すると値が昇順に並ぶため、
 * 同じ値が並んで出てくることを利用してモードを計算する。
 */
    private void inorder(TreeNode node){
        if(node == null) return ;
        inorder(node.left); //左を処理
        //直前の値と同じならカウントを増やす
        if(prev != null && node.val == prev){
            count++;
        }else{
            //違う値になったらカウントを１にリセット
            count = 1;
        }
        //出現回数の最大を更新する。
        if(count >maxCount){
            //新しい最大値が見つかったらリストをリセット
            modes.clear();
            modes.add(node.val);
            maxCount = count;
        }else if(count == maxCount){
            //最大出現回数と同じなら追加
            modes.add(node.val);
        }
        //現在の値をprevとして記録
        prev = node.val;
        //右を処理
        inorder(node.right);
    }
    //実行用mian
    public static void main(String[] args) {

        FindModeInBinarySearchTree modeFinder = new FindModeInBinarySearchTree();

        // ---- Example 1 ----
        Integer[] arr1 = {1, null, 2, 2};
        TreeNode root1 = ArrayToTree.arrayToTree(arr1);
        int[] ans1 = modeFinder.findMode(root1);
        System.out.println("Example 1 Output: " + Arrays.toString(ans1)); // [2]

        // ---- Example 2 ----
        Integer[] arr2 = {0};
        TreeNode root2 = ArrayToTree.arrayToTree(arr2);
        int[] ans2 = modeFinder.findMode(root2);
        System.out.println("Example 2 Output: " + Arrays.toString(ans2)); // [0]
    }
}
