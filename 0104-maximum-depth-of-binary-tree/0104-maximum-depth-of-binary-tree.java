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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

// BFS
// class Solution {
//     public int maxDepth(TreeNode root) {
//         if (root == null) return 0;

//         Queue<TreeNode> queue = new ArrayDeque<>();
//         queue.offer(root);

//         int depth = 0;

//         while (!queue.isEmpty()) {
//             int levelSize = queue.size(); // nodes at current level
//             depth++;                      // entering a new level

//             for (int i = 0; i < levelSize; i++) {
//                 TreeNode node = queue.poll();
//                 if (node.left != null) queue.offer(node.left);
//                 if (node.right != null) queue.offer(node.right);
//             }
//         }

//         return depth;
//     }
// }


