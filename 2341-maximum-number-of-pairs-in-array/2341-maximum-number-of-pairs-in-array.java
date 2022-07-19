class Solution {
    public int[] numberOfPairs(int[] nums) {
        int n = nums.length;
        int[] freq = new int[101]; //creatrred a freq array to store frq of nums array elements
        int [] ans = new int[2];
        
        for(int i =0;i<n;i++){
            freq[nums[i]]++;
        }
        
        for(int i=0;i<freq.length;i++){
            ans[1] += freq[i] % 2;  //if the there is remainder,means there is some elemnts which cant be paired coz they are odd in numbers
            ans[0] += freq[i] / 2;  //if the freq is divisible by 2 and given remainder 0,means there are even number of duplicates
        }
        
        return ans;
    }
}