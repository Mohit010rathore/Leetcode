class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int ans = Integer.MIN_VALUE;
        int maxi = values[0] + 0;
        
        for(int j=1;j<n;j++){
            ans = Math.max(ans, maxi + values[j]-j) ;
            maxi = Math.max(maxi,values[j] + j);
        }
        return ans;
    }
}