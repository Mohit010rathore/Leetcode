class Solution {
    public int[] numberOfPairs(int[] nums) {
        int n = nums.length;
        int[] freq = new int[101];
        int [] ans = new int[2];
        
        for(int i =0;i<n;i++){
            freq[nums[i]]++;
        }
        
        for(int i=0;i<freq.length;i++){
            ans[1] += freq[i] % 2;
            ans[0] += freq[i] / 2;
        }
        
        return ans;
    }
}