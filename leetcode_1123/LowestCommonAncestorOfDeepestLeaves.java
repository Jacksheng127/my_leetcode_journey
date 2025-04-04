package leetcode_1123;

import data_structure.TreeNode;
import java.util.*;

class LowestCommonAncestorOfDeepestLeaves {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int maxD = maxDepth(root);
        return dfs(root, maxD, 0);
    }

    private TreeNode dfs(TreeNode root, int maxD, int length){
        if(root == null) return null;
        if(maxD - 1 == length) return root;

        TreeNode left = dfs(root.left, maxD, length + 1);
        TreeNode right = dfs(root.right, maxD, length + 1);

        // If both left and right are not null, then root is the LCA of deepest leaves
        // This means we found the common ancestor of the deepest leaves
        if(left != null && right != null)
            return root;
        
        return left != null ? left : right;
    }

    private int maxDepth(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static List<Integer> serialize(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null) {
                result.add(curr.val);
                queue.offer(curr.left);
                queue.offer(curr.right);
            } else {
                result.add(null);
            }
        }

        // Remove trailing nulls to match LeetCode's output style
        while (!result.isEmpty() && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }

        return result;
    }


    public static void main(String[] args) {
        LowestCommonAncestorOfDeepestLeaves solution = new LowestCommonAncestorOfDeepestLeaves();
        // Example usage
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode lca = solution.lcaDeepestLeaves(root);
        List<Integer> serialized = serialize(lca);
        System.out.println("LCA of deepest leaves (as tree): " + serialized);
    }
    
}