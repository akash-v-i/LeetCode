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
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        find(root);
        return max;
    }

    public int find(TreeNode root) {
        if (root == null)
            return 0;
        // if(root.left==null && root.right==null){
        //     return root.val;
        // }
        int left = Math.max(0, find(root.left));
        int right = Math.max(0, find(root.right));
        max = Math.max(max, root.val + left + right);
        return root.val + Math.max(0,Math.max(left, right));
    }
}