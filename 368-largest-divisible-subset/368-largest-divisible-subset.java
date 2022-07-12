class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int hash[] = new int[n];
        int dp[] = new int[n];
        int max = 0, lastInd = 0;
        for(int i=0;i<n;i++)
        {
            dp[i] = 1;
            hash[i] = i;
            for(int j=0;j<i;j++)
            {
                if(nums[i] % nums[j] ==0)
                {
                    if(dp[i]<dp[j]+1)
                    {
                        dp[i]  = dp[j] +1;
                        hash[i] = j;
                    }
                }
            }
            if(max<dp[i]){
                max = dp[i]; lastInd = i;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[lastInd]);
        while(lastInd != hash[lastInd]){
            lastInd = hash[lastInd];
            list.add(nums[lastInd]);
        }
        return list;
    }
}