package leetcode_951;

class FlipEquivalentBinaryTrees{
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return checker(root1, root2);
    }

    public boolean checker(TreeNode node1, TreeNode node2)
    {
        if(node1 == null && node2 == null) return true;

        if(node1 == null || node2 == null || node1.val != node2.val) return false;

        return (checker(node1.left, node2.left) || checker(node1.left, node2.right)) && (checker(node1.right, node2.right) || checker(node1.right, node2.left));
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(8);
        root1.right.left = new TreeNode(6);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(6);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        root2.right.right.left = new TreeNode(8);
        root2.right.right.right = new TreeNode(7);

        FlipEquivalentBinaryTrees obj = new FlipEquivalentBinaryTrees();
        System.out.println(obj.flipEquiv(root1, root2));
    }
}