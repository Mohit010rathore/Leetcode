class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for(int el: nums){
            total+=el;
        }

        if(total%k !=0){
            return false;
        }

        if (nums.length < k) return false;

        int subsetSum = total/k;
        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, visited, 0, k, 0, subsetSum);

    }

    private boolean canPartition(int[] nums, boolean[] visited, int start, int k, int curSum, int subsetSum) {
        if (k == 0) return true;
        if (curSum > subsetSum) return false;
        if (curSum == subsetSum)  {
            return canPartition(nums, visited, 0, k - 1, 0, subsetSum);
        }

        for (int i = start; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (canPartition(nums, visited, i + 1, k, curSum + nums[i], subsetSum)) return true;
            visited[i] = false;
        }

        return false;
    }

//     public boolean helper(int i, int bucketNum, int bucketSum, int reqSum, int k, int[] nums, int[] visited){
//         if(bucketNum == k+1) return true;
        
//         if(bucketSum == reqSum){
//             //we will construct he 2nd bucket
//             return helper(0,bucketNum + 1,0,reqSum,k,nums,visited);
//         }
        
//         if(bucketSum > reqSum)return false;
        
//         if( i >= nums.length)return false;
        
//         if(visited[i] == 1){
//             return helper(i+1,bucketNum,bucketSum,reqSum,k,nums,visited);
//         }else{
//             //1. pick
//             bucketSum += nums[i];
//             visited[i] = 1;
//             boolean op1 = helper(i+1,bucketNum,bucketSum,reqSum,k,nums,visited);
            
//             //2. skip the ith ele
//             //undo the changes on 7th and 8th line
//             bucketSum -= nums[i];
//             visited[i] = 0;
//             boolean op2 = helper(i+1,bucketNum,bucketSum,reqSum,k,nums,visited);
            
//             return op1 | op2;
            
//         }
//     }
//     public boolean canPartitionKSubsets(int[] nums, int k) {
//         int n = nums.length;
//         int [] visited = new int[n];
//         int sum = 0;
//         for(int i = 0;i< n;i++){
//             visited[i] =0 ;
//         }
//         for(int i = 0;i<n;i++){
//             sum += nums[i];
//         }
//         if(sum % k != 0)return false;
//         int reqSum = sum  /k;
//         return helper(0,1,0,reqSum,k,nums,visited);
        
//     }
}