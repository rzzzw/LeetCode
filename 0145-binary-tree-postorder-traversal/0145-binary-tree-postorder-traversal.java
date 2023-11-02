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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        stack.offerFirst(root);
        
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peekFirst();
            if (prev == null || cur == prev.left || cur == prev.right) {
                if (cur.left != null) {
                    stack.offerFirst(cur.left);
                } else if (cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    res.add(cur.val);
                    stack.pollFirst();
                }
            } else if (prev == cur.left) {
                if (cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    res.add(cur.val);
                    stack.pollFirst();
                }
                
            } else {
                res.add(cur.val);
                stack.pollFirst();
            }
            prev = cur;
        }
        return res;

    }
}

/*
     1
    / \
   2   3
  / \
 4   5

stack: 1 2
prev: 5
cur: 2

res: 4 5

*/

// recursion:
// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         postorderTraversal(root, res);
//         return res;
//     }
    
//     private void postorderTraversal(TreeNode root, List<Integer> res) {
//         if (root == null) {
//             return;
//         }
//         postorderTraversal(root.left, res);
//         postorderTraversal(root.right, res);
//         res.add(root.val);
//     }
// }