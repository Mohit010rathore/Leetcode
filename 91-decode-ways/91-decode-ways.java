class Solution {
    public int f(int ind,String s,int dp[]){
        if(ind >= s.length()) return 1; //we exhausted the whole string,means we decoded the entirre string
        int ans = 0;
        
        if(dp[ind] > 0){
            return dp[ind];
        }
        
        int pick1 = s.charAt(ind) - '0'; // this will  actually give us the integer of the first digit
        int pick2 = 0;
        if(ind < s.length()-1){
            pick2 = pick1 * 10 + s.charAt(ind+1) - '0';
        } 
        
        if(pick1 > 0) ans += f(ind+1,s,dp);
        
        if(pick1 > 0 && pick2 > 0 && pick2 <= 26 ) ans += f(ind+2,s,dp);
        
        return dp[ind] = ans;
    }
    public int numDecodings(String s) {
        int dp[] = new int [101];
        return f(0,s,dp);
    }
}