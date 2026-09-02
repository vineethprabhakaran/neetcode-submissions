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
    public static int preIdx = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
          preIdx = 0;
          for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
          }
          return dfs(preorder, inorder, 0, preorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int l, int r) {
        if(l > r) return null;

        int rootVal = preorder[preIdx ++];
        int mid = map.get(rootVal);
        TreeNode node = new TreeNode(rootVal);
        node.left = dfs(preorder, inorder, l, mid -1);
        node.right = dfs(preorder, inorder, mid +1, r);
        return node;
    }


}
