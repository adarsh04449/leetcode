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
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return balanced;
    }

    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }

        int right =  helper(root.right);
        int left = helper(root.left);

        if(Math.abs(right - left) > 1){
            balanced = false;
        }

        return 1 + Math.max(left, right);


    }

}
