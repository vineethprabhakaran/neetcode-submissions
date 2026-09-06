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
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    public int[] dfs(TreeNode node){
        if(node == null){
            return new int[] {0, 0};
        }

        int[] leftPair = dfs(node.left);
        int[] rightPair = dfs(node.right);
        int withRoot = node.val + leftPair[1] + rightPair[1];
        int withoutRoot = Math.max(leftPair[0] , leftPair[1]) + 
                          Math.max(rightPair[0], rightPair[1]);
        
        return new int[] {withRoot, withoutRoot};
    }
}