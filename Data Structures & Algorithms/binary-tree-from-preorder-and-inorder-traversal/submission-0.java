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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1, inMap);
    }

    public TreeNode build(int[] preOrder, int[] inOrder, int preStart, int preEnd, int inStart, int inEnd, HashMap<Integer, Integer> inMap){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preStart]);

        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = build(preOrder, inOrder, preStart + 1, preStart + numsLeft, inStart, inRoot-1, inMap);
        root.right = build(preOrder, inOrder, preStart + numsLeft + 1, preEnd, inRoot+1, inEnd, inMap);

        return root;
    }
}
