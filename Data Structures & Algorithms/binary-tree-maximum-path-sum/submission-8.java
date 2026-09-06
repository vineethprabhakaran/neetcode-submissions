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
      static int maxSum;
    public int maxPathSum(TreeNode root) {
      maxSum = (root != null) ? root.val : 0;
        dfs(root);
        return maxSum;
    }

    public int dfs(TreeNode node) {
        if(node == null){
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);
        int maxValleft = Math.max(left, 0);
        int maxValRight = Math.max(right, 0);

        int sum = node.val + maxValleft + maxValRight;
        maxSum = Math.max(sum, maxSum);


        return node.val + Math.max(maxValleft , maxValRight);
    }
}
