package LeetCode.Tree;

import java.util.*;

public class ConvertSortedArray {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;

        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if(left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = build(nums, left, mid - 1);
        node.right = build(nums, mid + 1, right);

        return node;
    }
    public static Integer[] printLevelOrder(TreeNode root) {
        if(root == null) return new Integer[0];

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if(node == null) {
                list.add(null);
                continue;
            }
            list.add(node.val);

            if(node.left != null || node.right != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return list.toArray(new Integer[0]);
    }


    public static void main(String[] args) {
        ConvertSortedArray solution = new ConvertSortedArray();

        // testcase1
        int[] nums1 = {-10,-3,0,5,9};
        TreeNode result = solution.sortedArrayToBST(nums1);
        System.out.println("testcase1 " + Arrays.toString(printLevelOrder(result))); // Output: [0,-3,9,-10,null,5]

        System.out.println("=================");

        // testcase2
        int[] nums2 = {1,3};
        TreeNode result2 = solution.sortedArrayToBST(nums2);
        System.out.print("testcase2 " + Arrays.toString(printLevelOrder(result2))); // Output: [3,1]
    }
}



