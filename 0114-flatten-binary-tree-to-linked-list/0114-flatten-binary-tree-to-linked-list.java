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
Flatten the tree into a linked list in-place, following preorder traversal
root → left → right
Rules:
    Use the tree’s right pointers as next
    Set all left pointers to null
    Do not create new nodes
    
bottom up - 从下往上捋
Time O(n)
Space O(h)
 */

class Solution {
    public void flatten(TreeNode root) {
        TreeNode[] prev = new TreeNode[1];
        dfs(root, prev);
        return;
    }
    private void dfs(TreeNode node, TreeNode[] prev) {
        if (node == null) {
            return;
        }

        // Reverse preorder: right -> left -> node
        dfs(node.right, prev);
        dfs(node.left, prev);

        node.right = prev[0];
        node.left = null;
        prev[0] = node;
    }
}


// class Solution {
//   public void flatten(TreeNode root) {
//     TreeNode[] prev = new TreeNode[1];
//     helper(root, prev);
//     return;
//   }
//   private void helper(TreeNode node, TreeNode[] prev) {
//     if (node == null) {
//       return;
//     }
//     // step 1 先记录leftNode 和 rightNode 先记录再赋值
//     TreeNode leftNode = node.left;
//     TreeNode rightNode = node.right;

//     // Step 2: 核心逻辑 抹左连右
//     if (prev[0] != null) {
//       prev[0].right = node;
//     }
//     node.left = null;
//     prev[0] = node;

//     helper(leftNode, prev);
//     helper(rightNode, prev);
//   }
// }

