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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            /*
            Siblings - same depth and share the same parents
            cousins - same depth but with different parents
            
            for each node, read and offer its child(s) and offer a null node to reset siblings to false
            
            q: 
            2 3 null
            */
            
            boolean siblings = false;
            boolean cousins = false;

            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur == null) {
                    siblings = false;
                } else {
                    if (cur.val == x || cur.val == y) {
                        if (!cousins) {
                            siblings = cousins = true;
                        } else {
                            return !siblings;
                        }
                    }
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                    q.offer(null);
                }
            }

            if (cousins) {   // (early return) finished all the nodes in the layer of current depth, 1 node found, but no 2nd cousin, so return false
                return false;
            }
        }
        return false;
    }
}