class Solution {
    public int[] countBits(int n) {
        
        //ans[i] array at i -> stores no. of 1's from 0 to i
        int [] ans = new int[n+1];
        ans[0] = 0;
        
        for(int i=1;i<=n;i++){
            ans[i] = ans[i/2] + i%2; // i%2 adds 1 to the numbers which are odd and adds 0 if they are even
        }
        return ans;
    }
}