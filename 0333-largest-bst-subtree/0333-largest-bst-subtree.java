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
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        BSTInfo res = helper(root);
        return res.size;
    }
    
    private BSTInfo helper(TreeNode root) {
        if (root == null) {
            return new BSTInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        BSTInfo left = helper(root.left);
        BSTInfo right = helper(root.right);
        if (left.isBST && right.isBST && left.max < root.val && root.val < right.min) {
            int size = left.size + right.size + 1;
            int min = (left.size == 0) ? root.val : left.min;
            int max = (right.size == 0) ? root.val : right.max;
            return new BSTInfo(true, size, min, max);
            
        } else {
            return new BSTInfo(false, Math.max(left.size, right.size), 0, 0);
        }
    }
    
    class BSTInfo {
        boolean isBST;
        int size;
        int min;
        int max;
        
        BSTInfo(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;            
        }
    }
}