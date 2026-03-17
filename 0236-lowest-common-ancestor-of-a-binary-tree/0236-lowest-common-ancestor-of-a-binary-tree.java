/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
Time Complexity: O(n)
Space Complexity: O(n) (worst case), O(log n) (best case for balanced trees)

 */

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         // Base case 1: (important!) Reached the end → nothing found
//         if (root == null) {  
//             return root;
//         }

//         // Base case 2: Found one target node → return it upward
//         if (root == p || root == q) {
//             return root;
//         }
        
//         TreeNode left = lowestCommonAncestor(root.left, p, q);  // ask Left subtree: “Did you find p or q?”
//         TreeNode right = lowestCommonAncestor(root.right, p, q);
        
//         if (left != null && right != null) {  // p found in one side; q found in the other side
//             return root;
//         }
        
//         // If only one side found something → pass it upward; 
//         // If neither found anything → return null
//         return left != null ? left : right;  
//     }
// }

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}