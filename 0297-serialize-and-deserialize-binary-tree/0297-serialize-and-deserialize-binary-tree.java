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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        seriHelper(root, sb);
        return sb.toString();
    }
    private void seriHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        } 
        sb.append(root.val);
        sb.append(",");
        seriHelper(root.left, sb);
        seriHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        int[] index = new int[1];
        return deseriHelper(values, index);
    }

    private TreeNode deseriHelper(String[] values, int[] index) {
        if (values[index[0]].equals("null")) {
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(values[index[0]]));
        index[0]++;
        node.left = deseriHelper(values, index);
        node.right = deseriHelper(values, index);
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