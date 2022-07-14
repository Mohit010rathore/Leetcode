// class Solution {
//     public int f(int start ,int [] nums){
//         if(start >= nums.length){
//             return 0;
//         }
        
//         int minJump = Integer.MAX_VALUE;
//         for(int i = start + 1;i<start+nums[i];i++)
//     }
//     public int jump(int[] nums) {
//         int n =  nums.length;
//         int pos= 0;
//         int des = 0;
//         int count = 0;
        
//         for(int i=0;i<n-1;i++){
//             des = Math.max(des,i+nums[i]);
            
//             if(pos == i){
//                 pos = des;
//                 count++;
//             }
//         }
//         return count;
        
//     }
// }
class Solution {
    Integer dp[];
    public int helper(int i,int[] nums){
        if(i==nums.length-1) return 0;
        if(i>=nums.length) return Integer.MAX_VALUE-1;
        if(dp[i]!=null) return dp[i];
        int minJumps=Integer.MAX_VALUE-1;
        for(int k=1;k<=nums[i];k++){
            minJumps=Math.min(1+helper(i+k,nums),minJumps);
        }
        return dp[i]=minJumps;
    }
    public int jump(int[] nums) {
        dp=new Integer[nums.length];
        return helper(0,nums);
    }
}