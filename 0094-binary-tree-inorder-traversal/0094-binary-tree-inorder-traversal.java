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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode nextVisit = root;
        while (nextVisit != null || !stack.isEmpty()) {
            if (nextVisit != null) {
                stack.offerFirst(nextVisit);
                nextVisit = nextVisit.left;
            } else {
                TreeNode cur = stack.pollFirst();
                res.add(cur.val);
                nextVisit = cur.right;
            }
            
        }
        return res;
    }
}
/*
        1
       / \ 
      2   3

res 2 1
Deque: 
nextVisit: node3
cur: node1

*/
// Recursion:
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         inorderTraversal(root, res);
//         return res;
//     }
    
//     private void inorderTraversal(TreeNode root, List<Integer> res) {
//         if (root == null) {
//             return;
//         }
//         inorderTraversal(root.left, res);
//         res.add(root.val);
//         inorderTraversal(root.right, res);
//     }
// }