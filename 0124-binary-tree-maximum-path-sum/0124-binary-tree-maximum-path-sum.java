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
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = new int[]{Integer.MIN_VALUE};
        helper(root, res);
        return res[0];
    }
    // return the maxSum of 1 path
    private int helper(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        res[0] = Math.max(res[0], left + right + root.val); // result can be a negative number
        
        return Math.max(0, Math.max(left, right) + root.val);  // if the sum of a subtree from one node is a negative number, the subtree from that node need to be discarded
        // return left >= right ? (left + root.val) : (right + root.val);  ❌ this is for leaf to leaf case.
    }
}

/**
              1
            /   \
          -1     2

 */