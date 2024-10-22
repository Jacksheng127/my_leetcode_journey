import java.util.*;

class KthLargestSumInABinaryTree{
    public long kthLargestSum(TreeNode root, int k){
        List<Long> res = new ArrayList<>(); // To store sum of each level
        Queue<TreeNode> q = new LinkedList<>(); // Queue for level order traversal
        q.add(root);  // Start BFS from the root node

        while(!q.isEmpty())
        {
            int n = q.size(); // Number of nodes at current level
            long sum = 0; // Sum of node values at the current level

            for(int i=0; i<n; i++)
            {
                TreeNode node = q.poll();
                sum += node.val;

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            res.add(sum); // Store the sum of the current level
        }

        if(k > res.size()) return -1;

        res.sort(Collections.reverseOrder()); // Sort level sums in descending order
        return res.get(k-1); // Return the kth largest sum
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left = new TreeNode(3);

        KthLargestSumInABinaryTree obj = new KthLargestSumInABinaryTree();
        System.out.println(obj.kthLargestSum(root, 1)); 
    }


}