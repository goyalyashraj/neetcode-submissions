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
    Integer prev =null;
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        return inorder(root,k);
    }
    public int inorder(TreeNode root,int k){
        if(root ==null)return 0;
        inorder(root.left,k);
        

        if(list.size()==k){
            return prev;
        }
        prev = root.val;
        list.add(prev);
        inorder(root.right,k);
        return prev;
    }
}
