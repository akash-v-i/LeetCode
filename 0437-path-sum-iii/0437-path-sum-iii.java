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
    public int pathSum(TreeNode root, int target) {
        if(root==null) return 0;

        return find(root,target)
               +pathSum(root.left,target)
               +pathSum(root.right,target);
    }

    public int find(TreeNode root, long target){
        if(root==null) return 0;

        int co=0;

        if(root.val==target) co++;
        
        co+=(find(root.left,target-root.val));
        co+=(find(root.right,target-root.val));

        return co;
    }
}