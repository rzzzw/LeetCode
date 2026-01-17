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
 Maintain:
    currentSum: sum from root to current node
    map: { prefixSum → frequency }


  */
// class Solution {
//     public int pathSum(TreeNode root, int targetSum) {
//         Map<Long, Integer> prefixCount = new HashMap<>();
//         prefixCount.put(0L, 1);
//         return dfs(root, 0L, targetSum, prefixCount);
//     }

//     private int dfs(TreeNode node, long curSum, int target, Map<Long, Integer> prefixCount) {
//         if (node == null) {
//             return 0;
//         }
//         curSum += node.val;

//         int result = prefixCount.getOrDefault(curSum - target, 0);

//         prefixCount.put(curSum, prefixCount.getOrDefault(curSum, 0) + 1);

//         result += dfs(node.left, curSum, target, prefixCount);
//         result += dfs(node.right, curSum, target, prefixCount);

//         prefixCount.put(curSum, prefixCount.get(curSum)  - 1);

//         return result;
//     }
// }
/**
 */


class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        int[] res = new int[1];
        Map<Long, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0L, 1);
        dfs(root, targetSum, 0L, prefixCount, res);
        return res[0];
    }
    private void dfs(TreeNode node, int target, long curSum, Map<Long, Integer> prefixCount, int[] res) {
        if (node == null) {
            return;
        }
        curSum += node.val;

        res[0] += prefixCount.getOrDefault(curSum - target, 0);

        prefixCount.put(curSum, prefixCount.getOrDefault(curSum, 0) + 1);

        dfs(node.left, target, curSum, prefixCount, res);
        dfs(node.right, target, curSum, prefixCount, res);

        prefixCount.put(curSum, prefixCount.get(curSum) - 1);
    }
}