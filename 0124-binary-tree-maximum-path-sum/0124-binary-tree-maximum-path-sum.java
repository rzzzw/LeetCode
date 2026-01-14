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


/**
Time: (n)
Space: O(h)
 */

class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] max = new int[]{Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }
    private int helper(TreeNode node, int[] max) {  // why not "void"? what value need to be returned
        if (node == null) {
            return 0;
        }
        int left = helper(node.left, max);
        int right = helper(node.right, max);
        max[0] = Math.max(max[0], left + right + node.val);
        return Math.max(0, Math.max(left, right) + node.val);
    }
}