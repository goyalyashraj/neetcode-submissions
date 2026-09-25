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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null )return null;
        if(root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        }

        if(left != null){
            return left;
        } else {
            return right;
        }
        // while(root!=null){
        //     if(p.val < root.val && q.val < root.val){
        //         root= root.left;
        //     }
        //      else if(p.val > root.val && q.val > root.val){
        //         root= root.right;
        //     }
        //     else{
        //         return root;
        //     }
        // }
        // return null;
    }
}