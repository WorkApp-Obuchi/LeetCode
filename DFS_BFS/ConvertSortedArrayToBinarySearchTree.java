
import common.TreeNode;
import common.TreeUtils;
/*
 * 108. Convert Sorted Array to Binary Search Tree
 * 与えられた昇順配列から高さがバランスされた二分探索木（BST）を作成する。
 * 再帰的に配列の中央を根として左右部分木を作成する。
 */
public class ConvertSortedArrayToBinarySearchTree {
    /*
    * 配列から高さバランスのBSTを作成する
    * @param　nums 昇順に並んだ整数配列
    * @return 配列から作成されたBSTの根ノード
    */
    public TreeNode sortedArrayToBST(int[] nums) {
        //配列全体を範囲としてbuild()を呼び出す
        return build(nums, 0 ,nums.length -1);
    }
    /*
    * 配列の指定範囲から部分木を作成する再帰メソッド
    * @param　nums 配列
    * @param left 現在の部分配列の左端インデックス
    * @param right 現在の部分配列の右端インデックス
    * @return 作成された部分木の根ノード
    */
    private TreeNode build(int[] nums ,int left,int right){
        //配列の範囲がなくなったらnullを返す
        if(left > right) return null;
        //中央インデックスを取得
        int mid = left + (right - left) / 2 ;
        //中央の値を根ノードとして作成
        TreeNode root = new TreeNode(nums[mid]);
        // 左半分の配列で左部分木を作成
        root.left = build(nums, left, mid - 1);
        // 右半分の配列で右部分木を作成
        root.right = build(nums,mid  + 1, right);

        return root;
    }
    //実行用main
   public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree bstConverter = new ConvertSortedArrayToBinarySearchTree();

        // Example 1
        int[] nums1 = {-10, -3, 0, 5, 9};
        TreeNode root1 = bstConverter.sortedArrayToBST(nums1);
        System.out.println("Example 1 Output: " + TreeUtils.toLevelOrderArray(root1));

        // Example 2
        int[] nums2 = {1, 3};
        TreeNode root2 = bstConverter.sortedArrayToBST(nums2);
        System.out.println("Example 2 Output: " + TreeUtils.toLevelOrderArray(root2));
    }
}
