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
// class Solution {
//     public int maxPathSum(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
//         int[] max = new int[]{Integer.MIN_VALUE};
//         helper(root, max);
//         return max[0];

//     }

//     private int helper(TreeNode root, int[] max) {
//         if (root == null) {
//             return 0;
//         }
//         int left = helper(root.left, max);
//         int right = helper(root.right, max);       
//         max[0] = Math.max(max[0], left + right + root.val);

//         // return left >= right ? (left + root.val) : (right + root.val);  ❌ 这种写法的结果是，通往两个叶子结点。但对于这道题，如果一个分支从某个中间节点开始往下是负数，则该中间节点及以下应该被抛弃
//         return Math.max(0, Math.max(left, right) + root.val); 


//     }
// }

/**
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
    private int helper(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left, max);
        int right = helper(node.right, max);
        max[0] = Math.max(max[0], left + right + node.val);
        return Math.max(0, node.val + Math.max(left, right));
    }
}