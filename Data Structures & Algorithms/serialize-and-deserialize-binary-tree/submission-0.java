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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsSerialize(root, res);
        return String.join(",", res);
    }

    public void dfsSerialize(TreeNode node, List<String> res){
        if (node == null) {
            res.add("N");
            return;
        }

        res.add(String.valueOf(node.val));
        dfsSerialize(node.left, res);
        dfsSerialize(node.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] idx = new int[1];
        return dfsDeserialize(vals, idx);
    }

    public TreeNode dfsDeserialize(String[] vals, int[] idx){
        if(vals[idx[0]].equals("N")){
            idx[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(vals[idx[0]]));
        idx[0]++;

        node.left = dfsDeserialize(vals, idx);
        node.right = dfsDeserialize(vals,idx);

        return node;
    }
}
