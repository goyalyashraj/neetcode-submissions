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
    int index =0;
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i =0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        int n = inorder.length;
        return build(preorder,0,n-1);
    }
    public TreeNode build(int[] preorder, int inorderS , int inorderE){
       if(inorderS>inorderE)return null;

        int rootval = preorder[index++];
        TreeNode root = new TreeNode (rootval);
        int rootI = map.get(rootval);
     root.left = build(preorder,inorderS,rootI-1);
    root.right = build(preorder,rootI+1,inorderE);
        return root;
    }
}
