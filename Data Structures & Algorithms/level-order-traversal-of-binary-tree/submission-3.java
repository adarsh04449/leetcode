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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<List<Integer>> res = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size();

            List<Integer> currLevel = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();

                if(curr == null){
                    continue;
                }

                currLevel.add(curr.val);

                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            res.add(currLevel);
        }

        return res;

    }
}
