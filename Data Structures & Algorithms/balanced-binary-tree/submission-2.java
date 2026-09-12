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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        return dfs(root)[0] == 0;
    }

    public int[] dfs(TreeNode root) {
        if(root == null){
            return new int[] {0, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        
        boolean balanced = left[0] == 0 && right[0] == 0 && (Math.abs(left[1]-right[1]) <= 1);

        
        int height = 1 + Math.max(left[1], right[1]);
        return new int[]{balanced ? 0 : 1, height};
    }
}
