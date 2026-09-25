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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return false;
        }
        if(subRoot == null){
            return true;
        }
        if(root.val == subRoot.val){
             if(isIdentical(root,subRoot)){
                return true;
            }
        }
        if(isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot)){
            return true;
        }
        return false;

    }
    public static  boolean isIdentical(TreeNode root, TreeNode subRoot){
         if(root==null && subRoot==null){
            return true;
        }
        if(root==null || subRoot==null){
            return false;
        }
        if(root.val == subRoot.val){
            if(isIdentical(root.left,subRoot.left)&& isIdentical(root.right,subRoot.right)){
                return true;
            }

        }
        return false;
    }
}
