package leetcode_1261;
import java.util.HashSet;
import java.util.Set;

import data_structure.TreeNode;

class FindElementsInAContaminatedBinaryTree {
    Set<Integer> set;
    public FindElementsInAContaminatedBinaryTree(TreeNode root){
        set = new HashSet<>();
        recoverTree(root, 0);
    }

    public void recoverTree(TreeNode root, int value){
        if(root == null) return;
        set.add(value);
        root.val = value;
        recoverTree(root.left, 2 * value + 1);
        recoverTree(root.right, 2 * value + 2);
    }

    public boolean find(int target){
        return set.contains(target);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.right = new TreeNode(-1);
        FindElementsInAContaminatedBinaryTree obj = new FindElementsInAContaminatedBinaryTree(root);
        System.out.println(obj.find(1));
        System.out.println(obj.find(2));
    }
    
}