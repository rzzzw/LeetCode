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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Deque<TreeNode> deque = new ArrayDeque<>();
        
        deque.offerFirst(root);
        
        int level = 0;
        while (!deque.isEmpty()) {
            List<Integer> curLayer = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i< size; i++) {
                if (level % 2 == 1) {
                    TreeNode cur = deque.pollLast();
                    curLayer.add(cur.val);                    
                    if (cur.right != null) deque.offerFirst(cur.right);
                    if (cur.left != null) deque.offerFirst(cur.left);
                } else {
                    TreeNode cur = deque.pollFirst();
                    curLayer.add(cur.val);
                    if (cur.left != null) deque.offerLast(cur.left);                        
                    if (cur.right != null) deque.offerLast(cur.right);                
                }        
            }
            level++;
            res.add(curLayer);
        }
        return res;
    }
}

// deque