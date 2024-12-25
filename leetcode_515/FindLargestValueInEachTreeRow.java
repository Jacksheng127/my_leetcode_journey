import java.util.ArrayList;
import java.util.List;
import data_structure.TreeNode;

class FindLargestValueInEachTreeRow {
    private List<Integer> res;
    public List<Integer> largestValues(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0);

        return res;
    }

    private void dfs(TreeNode root, int level) {
        if(root != null)
        {
            int val = root.val;

            if(res.size() == level)
                res.add(val);
            else
                res.set(level, Math.max(res.get(level), val));
            
            dfs(root.left, level + 1);
            dfs(root.right, level + 1);
        }
    }

    public static void main(String[] args) {
        FindLargestValueInEachTreeRow sol = new FindLargestValueInEachTreeRow();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        List<Integer> res = sol.largestValues(root);
        for(int val : res)
            System.out.print(val + " ");
    }
}