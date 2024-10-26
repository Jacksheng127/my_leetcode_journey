package data_structure;

/**
 * Represents a node in a binary tree.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    /**
     * Default constructor.
     */
    public TreeNode() {}

    /**
     * Constructor with value.
     * @param val the value of the node.
     */
    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * Constructor with value, left child, and right child.
     * @param val the value of the node.
     * @param left the left child of the node.
     * @param right the right child of the node.
     */
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // Getters and Setters
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}