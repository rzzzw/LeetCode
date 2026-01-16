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

 BST -> inorder traversal = sorted order

    => The k-th smallest element is the k-th node visited in inorder traversal.

  */

class Solution{
    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[1];
        int[] count = new int[]{1};
        inOrder(root, k, count, res);
        return res[0];
    }
    private void inOrder(TreeNode node, int k, int[] count, int[] res) {
        if (node == null) {
            return;
        }

        // left
        inOrder(node.left, k, count, res);

        // root
        if (count[0] == k) {
            res[0] = node.val;
        }
        count[0]++;
        
        // right
        inOrder(node.right, k, count, res);
    }
}

