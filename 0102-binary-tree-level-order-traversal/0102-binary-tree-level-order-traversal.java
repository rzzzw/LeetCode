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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, 0, res);
        return res;
    }
    
    private void helper(TreeNode node, int level, List<List<Integer>> res) {
        if (level == res.size()) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(node.val);
        if (node.left != null) {
            helper(node.left, level + 1, res);
        }
        if (node.right != null) {
            helper(node.right, level + 1, res);
        }
    }
}

/*





// BFS:
        1
      /   \
     2     3
    / \
   4   5
   
   q:    4 5
   size: 0
   cur:  3
   curL: {2, 3}
   
   {{1}, {2, 3}}

TC: O(N)
SC: O(N)

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> curLayer = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                curLayer.add(cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            res.add(curLayer);
        }
        return res;
    }
}

// DFS:

            1
          /   \
         2     3
        / \
       4   5

    helper(Node5, level2, res)
    level:    2
    res: {{1}, {2}, {4, 5}}

TC: O(N)
SC: O(N) <= O(N + height)

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, 0, res);
        return res;
    }
    
    private void helper(TreeNode node, int level, List<List<Integer>> res) {
        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(node.val);
        
        if (node.left != null) {
            helper(node.left, level + 1, res);
        }
        if (node.right != null) {
            helper(node.right, level + 1, res);
        }
    }
}


*/









