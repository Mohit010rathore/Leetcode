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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(queue.isEmpty() == false){
            // here we have to get the size of the queue, as we want to know how many nodes aere there in a single level
            int size = queue.size();
            
            //for every single level we have to make the list of all nodes values
            //this will hold the values of nodes of that level;
            List<Integer> currentLevel = new ArrayList<>();
            
            //now we iterate through all the things in our queue
            for(int i = 0; i < size ; i++){
                TreeNode curr = queue.poll();
                currentLevel.add(curr.val);
                
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            
            res.add(currentLevel);
            
        }
        return res;
    }
}