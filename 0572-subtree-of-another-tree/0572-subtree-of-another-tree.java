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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (isIdentical(root, subRoot)) {
            return true;
        }
        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }

    private boolean isIdentical(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == null && node2 == null; 
        }
        return node1.val == node2.val && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
    }
}