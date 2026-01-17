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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode node, int[] res) {
        if (node == null) {
            return 0;
        }

        int leftHeight = dfs(node.left, res);
        int rightHeight = dfs(node.right, res);

        res[0] = Math.max(res[0], leftHeight + rightHeight);

        // return height to parent
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

/**

Diameter at a node = left height + right height
Diameter can appear anywhere, not just at root
DFS must:
    Return height upward
    Update global diameter


 */
