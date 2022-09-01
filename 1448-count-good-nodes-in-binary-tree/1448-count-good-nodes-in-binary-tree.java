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
    int count = 0;
    public int goodNodes(TreeNode root) {
        countgoodNodes(root,root.val);
        return count;
    }
    
    public void countgoodNodes(TreeNode root,int currMax){
        if(root == null) return ;
        
        //if the present node value is greater than currmax than count++ and curr max will be updated
        if(root.val >= currMax ){
            count++;
            currMax = root.val;
        }
        
        //if we got the nodes which are lesser than currMax value
        //then we simply do the recursion
        if(root.left != null){
            countgoodNodes(root.left,currMax);
        }
        if(root.right != null){
             countgoodNodes(root.right,currMax);    
        }
        
    }
}