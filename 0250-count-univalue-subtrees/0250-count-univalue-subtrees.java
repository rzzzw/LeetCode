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
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        int[] res = {0};
        helper(root, res);
        return res[0];
    }
    private boolean helper(TreeNode root, int[] res) {
        if (root == null) return true;
        boolean left = helper(root.left, res);
        boolean right = helper(root.right, res);
        
        if (left && right) {
            if ((root.left != null && root.left.val == root.val) || root.left == null) {
                if ((root.right != null && root.right.val == root.val) || root.right == null) {
                    res[0]++;
                    return true;
                }
            }
        } 
        return false;
    }
}