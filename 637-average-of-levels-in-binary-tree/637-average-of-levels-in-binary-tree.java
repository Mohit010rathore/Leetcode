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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            double totalSum = 0;
            int noOfEle = size;
            
            while(size -- > 0){
                TreeNode head = q.poll();
                totalSum += head.val;
                if(head.right != null){
                    q.add(head.right);
                }
                if(head.left != null){
                    q.add(head.left);
                }
            }
            ans.add(new Double(totalSum/noOfEle));
        }
        return ans;
    }
}