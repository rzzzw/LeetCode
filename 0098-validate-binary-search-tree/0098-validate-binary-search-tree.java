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
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }
    
    private boolean isBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }
}


// // Bottom-up
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         if (root == null || root.left == null && root.right == null) {
//             return true;
//         }
//         BSTInfo res = helper(root);
//         return res.isBST;
//     }
    
//     private BSTInfo helper(TreeNode node) {
//         if (node == null) {
//             return new BSTInfo(true, Long.MAX_VALUE, Long.MIN_VALUE);
//         } 
        
//         BSTInfo left = helper(node.left);
//         BSTInfo right = helper(node.right);
        
//         if (left.isBST && right.isBST && node.val > left.max && node.val < right.min) {
//             long min = (node.left == null) ? node.val : left.min;
//             long max = (node.right == null) ? node.val : right.max;
//             return new BSTInfo(true, min, max);
//         } 
//         return new BSTInfo(false, 0, 0);
        
//     }
    
//     class BSTInfo {
//         boolean isBST;
//         long min;
//         long max;
        
//         BSTInfo(boolean isBST, long min, long max) {
//             this.isBST = isBST;
//             this.min = min;
//             this.max = max;
//         }
//     }
// }