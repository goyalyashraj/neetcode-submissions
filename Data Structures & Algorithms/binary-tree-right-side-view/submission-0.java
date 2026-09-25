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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)return list;
        q.add(root);
        q.add(null);
        TreeNode curr =null;
        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            if(temp == null){
                list.add(curr.val);
                if(q.isEmpty()){break;}
                else{q.add(null);}
            }else{
                curr= temp;
                if(temp.left!=null){
                    q.add(temp.left);
                } if(temp.right!=null){
                    q.add(temp.right);
                }
            }
        }
        return list;
        
    }
}
