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

// range DFS
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
//     }
//     private boolean dfs(TreeNode node, long min, long max) {
//         if (node == null) {
//             return true;
//         }
//         if (node.val <= min || node.val >= max) {
//             return false;
//         }
//         return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
//     }
// }
/**
Why long, not int?
    Because node values can be Integer.MIN_VALUE or Integer.MAX_VALUE.


Time: O(n)
Space: O(h) recursion stack
 */


//Inorder traversal (sorted array insight - Inorder traversal of a BST is strictly increasing)
class Solution {
    Long prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) return false;

        if (prev != null && root.val <= prev) {
            return false;
        }
        prev = (long) root.val;

        return isValidBST(root.right);
    }
}
