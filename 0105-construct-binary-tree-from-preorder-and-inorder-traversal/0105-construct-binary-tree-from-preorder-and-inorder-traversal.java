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

/**
preorder: root -> left -> right
inorder: left -> root -> right

preorder tells the root at each step, combing with inorder array to split left and right subtrees. 
recursively build the tree by consuming preorder in order and using inorder indices to bound subtrees

complexity:
    Time: O(n)
    Space: O(h)
 */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int[] preorderIdx = new int[1];
        return build(preorder, 0, preorder.length - 1, map, preorderIdx);
    }
    private TreeNode build(int[] preorder, int left, int right, Map<Integer, Integer> map, int[] preorderIdx) {
        if (left > right) {
            return null;
        }
        int rootVal = preorder[preorderIdx[0]];
        preorderIdx[0]++;
        TreeNode root = new TreeNode(rootVal);

        int inorderIdx = map.get(rootVal);

        root.left = build(preorder, left, inorderIdx - 1, map, preorderIdx);
        root.right = build(preorder, inorderIdx + 1, right, map, preorderIdx);
        
        return root;
    }
}


