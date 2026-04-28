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
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(inorder.length==0) return null;
        int index=0;
        for(int i=0;i<inorder.length;i++){
            if(postorder[postorder.length-1]==inorder[i]){
                index=i;
                break;
            }
        }
        TreeNode root=new TreeNode(postorder[postorder.length-1]);
        root.left=buildTree(Arrays.copyOfRange(inorder,0,index),Arrays.copyOfRange(postorder,0,index));
        root.right=buildTree(Arrays.copyOfRange(inorder,index+1,inorder.length),Arrays.copyOfRange(postorder,index,postorder.length-1));

        return root;
    }
}

/*

INor=[9,3,15,20,7] left root right
      0 1 2  3  4

POST=[9,15,7,20,3] left right root
      0 1  2  3 4

*/