/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, 0, res);
        return res;
    }
    
    private void helper(TreeNode node, int level, List<List<Integer>> res) {
        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(node.val);
        
        if (node.left != null) {
            helper(node.left, level + 1, res);
        }
        if (node.right != null) {
            helper(node.right, level + 1, res);
        }
    }
}

/*
        1
      /   \
     2     3
    / \
   4   5
   
[[1][2][4, 5]]

*/