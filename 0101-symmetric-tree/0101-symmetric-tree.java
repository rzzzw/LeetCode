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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return helper(a.left, b.right) && helper(a.right, b.left);
    }
}
/**
1.Problem understanding
  The left subtree must be a mirror image of the right subtree.
  Symmetry is not the same as equality. Must compare:
       - left.left ↔ right.right
       - left.right ↔ right.left

  Constrain & corner cases:
    Single node
    One side null, the other not
    Same values but different structure ❌
    
2. Interview Strategy 
    “This is naturally a recursive problem. I’ll compare the left and right subtrees in a mirror fashion.”

3. Step-by-Step Solution Developement
    a. Recursion insight -> Trees are symmetric if:
        - Both are null (One is null -> not symmetric)
        - Values equal
        - Outer and inner children mirror each other

    b. Define recursive helper -> helper(node1, node2)

    c. Recursive rules:
        helper(a, b) is true if:
            - a == null && b == null
            - a.val == b.val
            - helper(a.left, b.right) && helper(a.right, b.left) are true

4. Implementation

5. Complexity Analysis
    Time: O(n)
    Space: O(h)

 */