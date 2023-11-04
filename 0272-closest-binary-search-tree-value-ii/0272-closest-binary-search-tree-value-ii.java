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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        helper(root, target, k, q);
        for (int i = 0; i < k; i++) {
            res.add(q.poll());
        }
        return res;
    }
    
    private void helper(TreeNode root, double target, int k, Queue<Integer> q) {
        if(root == null) {
            return;
        }
        helper(root.left, target, k, q);
        if (q.size() < k) {
            q.offer(root.val);
        } else {
            if (Math.abs(root.val - target) < Math.abs(q.peek() - target)) {
                q.poll();
                q.offer(root.val);
            }
        }
        helper(root.right, target, k, q);
    }
}