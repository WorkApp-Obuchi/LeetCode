package LeetCode.Tree;

import java.util.*;

public class ReFindMode {
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        traverse(root, map);

        int maxCount = Collections.max(map.values());
        List<Integer> result = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == maxCount) {
                result.add(entry.getKey());
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
    private void traverse(TreeNode node, Map<Integer, Integer> map) {
        if(node == null) return;

        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        traverse(node.left, map);
        traverse(node.right, map);
    }

    public static void main(String[] args) {
        ReFindMode solution  = new ReFindMode();

        // testcase1
        TreeNode root1 = new TreeNode(1);
        root1.left = null;
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(2);
        root1.right.right = null;

        int[] result1 = solution.findMode(root1);
        System.out.println(Arrays.toString(result1));

        // testcase2
        TreeNode root2 = new TreeNode(0);

        int[] result2 = solution.findMode(root2);
        System.out.println(Arrays.toString(result2));
    }
}
