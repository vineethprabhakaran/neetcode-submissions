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
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, null, null);
    }

    public boolean validateBST(TreeNode node, TreeNode min, TreeNode max){
        if(node == null){
            return true;
        }

        if((min != null && node.val <= min.val) || (max != null && node.val >= max.val)){
            return false;
        }

      

        return validateBST(node.left, min, node) &&
        validateBST(node.right, node, max);

    }
}
