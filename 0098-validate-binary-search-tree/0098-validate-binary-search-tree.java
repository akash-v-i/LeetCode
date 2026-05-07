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
        return isValid(root,null,null);
    }
    public boolean isValid(TreeNode node,Integer max,Integer min){
        if(node==null){
            return true;
        }
        if(max!=null && node.val>=max){
            return false;
        }
        if(min!=null && node.val<=min){
            return false;
        }
        boolean left=isValid(node.left,node.val,min);

        boolean right=isValid(node.right,max,node.val);

        return left&&right;
    }
}