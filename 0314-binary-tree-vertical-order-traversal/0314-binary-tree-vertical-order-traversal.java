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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        int[] minMax = new int[]{0,0};
        helper(root, 0, minMax);
        
        for (int i = minMax[0]; i <= minMax[1]; i++) {
            res.add(new ArrayList<>());
        }
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<Integer> idx = new ArrayDeque<>();
        
        queue.offer(root);
        idx.offer(-minMax[0]);
        
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curIdx = idx.poll();
            res.get(curIdx).add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
                idx.offer(curIdx - 1);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                idx.offer(curIdx + 1);
            }
        }
        return res;       
        
    }
    
    private void helper(TreeNode root, int idx, int[] minMax) {     // find the min_max range
        if (root == null) return;
        minMax[0] = Math.min(minMax[0], idx); // min
        minMax[1] = Math.max(minMax[1], idx); // max
        helper(root.left, idx - 1, minMax);
        helper(root.right, idx + 1, minMax);
    }
}

/*
         3
       /   \ 
      9     20
      |    /  \
      |  15    7
      |        |
      |        |
    --|--|--|--|-> 
     -1  0  1  2
     min       max
     
idx   0  1  2  3
    
root_idx == -min == 1


*/
    
    
    