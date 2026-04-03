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
    public int goodNodes(TreeNode root) {
        return helper(root, root.val);
    }

    public int helper(TreeNode root, int prevMax){
        if(root == null){
            return 0;
        }

        int isGood = root.val < prevMax ? 0 : 1;
        int left = helper(root.left, Math.max(prevMax, root.val));
        int right = helper(root.right, Math.max(prevMax, root.val));

        return isGood + left + right;
    }
}
