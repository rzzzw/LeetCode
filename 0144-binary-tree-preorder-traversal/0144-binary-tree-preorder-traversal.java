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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            res.add(cur.val);
            if (cur.right != null) {
               stack.offerFirst(cur.right); 
            }
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }            
        }
        return res;
    }
}

//TC: O(n)
//SC: O(height) 每一层的right 压栈


// recursion: 
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        preorderTraversal(root, res);
//        return res;
//     }

//     private void preorderTraversal(TreeNode root, List<Integer> res) {
//         if (root == null) {
//             return;
//         }
//         res.add(root.val);
//         preorderTraversal(root.left, res);
//         preorderTraversal(root.right, res);
//     }
// }