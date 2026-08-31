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
    ArrayList<Integer> mapping = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        DFS(root);
        return mapping.get(k-1);
    }

    public void DFS(TreeNode node) {
        if (node == null) { return; }
        if (node.left != null) { DFS(node.left); }
        this.mapping.add(node.val);
        if (node.right != null) { DFS(node.right); }
    }


}
