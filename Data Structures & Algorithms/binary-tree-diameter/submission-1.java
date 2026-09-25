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
    int dia =0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;

       
        int dia1= diameterOfBinaryTree(root.left);
        int dia2= diameterOfBinaryTree(root.right);
        int dia3 = height(root.left) +height(root.right);

        int max = Math.max(dia3,Math.max(dia1,dia2));
        return max;
        
    }
    public int height(TreeNode root){
        if(root==null)return 0;
        int left = height(root.left);
        int right = height (root.right);
        int max = Math.max(left,right);
        return max+1;
    }
}
