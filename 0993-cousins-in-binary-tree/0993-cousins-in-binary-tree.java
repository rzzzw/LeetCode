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
		while(!q.isEmpty()) {
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
            // Early Stop
            if (cousins) {
                return false;
            }
        }
        return false;
    }
}

/*
Siblings - same depth and share the same parents
Cousins - same depth but with different parents

BFS (traverse by layer ← use a size variable for layer control)
Find cousins in the same layer. → How to avoid the case of siblings?
   ⇒ For each node, read and offer its child(s), additionally add a null node to note the end of sibling(s) with the same father node. 

Implementation: 
When each layer starts, initiate the Siblings and Cousins flag as false.
Once a target node is matched, set both Siblings and Cousins to true
Reset siblings to false when meeting a null node (null node is a trick used to note the end of sibling(s))

Early Stop Strategy:
Given the binary tree with unique values, when the traversal of a certain layer ends, if the Cousins flag is true with only 1 target node found. Return false cause it’s impossible to find 2 cousins in the same layer anymore.

TC: O(n)
SC: O(n)

*/