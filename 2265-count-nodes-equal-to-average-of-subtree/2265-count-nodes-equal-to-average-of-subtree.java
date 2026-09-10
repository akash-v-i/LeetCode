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
    int ans=0;
    public int averageOfSubtree(TreeNode root) {
        find(root);
        return ans;
    }

    public void find(TreeNode root){
        if(root==null) return;
        find(root.left);
        find(root.right);
        int sum=findSum(root);
        int node=findNodes(root); 
        if(root.val==sum/node) ans++;
    }

    public int findSum(TreeNode root){
        if(root==null) return 0;
        return root.val+findSum(root.left)+findSum(root.right);
    }

    public int findNodes(TreeNode root){
        if(root==null) return 0;
        return 1+findNodes(root.left)+findNodes(root.right);
    }
}