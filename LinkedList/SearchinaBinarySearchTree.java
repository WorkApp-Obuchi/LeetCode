  /*
   * 700. Search in a Binary Search Tree
   * 二分探索木(BST) 左の子は親より小さく、右の子は親より大きい
   *
   * @param root 探索対象の二分探索木のルート
   * @param val  探したい値
   * @return 指定された値を持つノード、存在しなければ null
   */

// TreeNode の定義
class TreeNode {
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

public class SearchinaBinarySearchTree {
      public TreeNode searchBST(TreeNode root, int val) {
        while(root != null){
            if(root.val == val){
                return root; //見つかった！！
            }

            if (val < root.val){ //左の子は親より小さい、右の子は親より大きい(二分探索木の考え)
                return searchBST(root.left, val); //左へ進む
            }else{
                return searchBST(root.right, val); //右へ進む
            }
        }
        return null; //見つからなかった、、
    }
    //動作確認用main
    public static void main(String[] args) {
        // Example 1: root = [4,2,7,1,3], val = 2
        TreeNode root1 = new TreeNode(4,
                            new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                            new TreeNode(7));
        int val1 = 2;

        SearchinaBinarySearchTree sol = new SearchinaBinarySearchTree();
        TreeNode res1 = sol.searchBST(root1, val1);
        System.out.println("Example 1: " + (res1 != null ? res1.val : "null"));

        // Example 2: root = [4,2,7,1,3], val = 5
        TreeNode root2 = new TreeNode(4,
                            new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                            new TreeNode(7));
        int val2 = 5;

        TreeNode res2 = sol.searchBST(root2, val2);
        System.out.println("Example 2: " + (res2 != null ? res2.val : "null"));
    }
}
