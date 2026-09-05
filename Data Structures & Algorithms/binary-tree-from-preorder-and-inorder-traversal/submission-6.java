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
    public  int preIdx = 0;
    public  int inIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
          preIdx = 0;
          return dfs(preorder, inorder, Integer.MAX_VALUE);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int limit) {

        if(preIdx >= preorder.length) {return null;}
        if(inorder[inIdx] == limit){
            inIdx++;
            return null;
        }

        TreeNode node = new TreeNode(preorder[preIdx++]);
        node.left = dfs(preorder, inorder, node.val);
        node.right = dfs(preorder, inorder, limit);
        return node;
    }


}
