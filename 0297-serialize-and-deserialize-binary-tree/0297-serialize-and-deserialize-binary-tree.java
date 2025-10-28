/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        seriHelper(root, sb);
        return sb.toString();
    }

    private void seriHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        seriHelper(node.left, sb);
        seriHelper(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        int[] index = new int[1];
        return deseriHelper(values, index); 
    }

    private TreeNode deseriHelper(String[] strs, int[] idx) {
        if (strs[idx[0]].equals("null")) {
            idx[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(strs[idx[0]]));
        idx[0]++;
        node.left = deseriHelper(strs, idx);
        node.right = deseriHelper(strs, idx);
        return node;
    }
}


/**

     1
    / \
   2   3
      / \
     4   5

DFS:
- Serialize
        1, 2, null, null, 3, 4, null, null, 5, null, null
       idx
- Deserialize
                                1
                        2               3
                     n     n         4     
                                   n   n


                                 




 */
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

