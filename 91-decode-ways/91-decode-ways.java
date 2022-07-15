class Solution {
    //Memoization
    public int f(int ind,String s,int dp[]){
        if(ind >= s.length()) return 1; //we exhausted the whole string,means we decoded the entirre string
        int ans = 0;
        
        if(dp[ind] > 0){
            return dp[ind];
        }
        
        int pick1 = s.charAt(ind) - '0'; // this will  actually give us the integer of the first digit
        int pick2 = 0;
        if(ind < s.length()-1){
            pick2 = pick1 * 10 + s.charAt(ind+1) - '0'; //this will give us the value in int for the first two numbers 
        } 
        
        if(pick1 > 0) ans += f(ind+1,s,dp);
        
        if(pick1 > 0 && pick2 > 0 && pick2 <= 26 ) ans += f(ind+2,s,dp); //ex - "06" remains when we apply our code pick1 will give 0, and pick2 will give 6 and return 1,but its wrong .. so we check if pick1 > 0 or not.
        
        return dp[ind] = ans;
    }
    public int numDecodings(String s) {
        // int dp[] = new int [101];
        // return f(0,s,dp);
        int n = s.length();
        int dp[] = new int [n+2];
        dp[n] = 1; //anything which is greater or equal than n, will give 1
        dp[n+1] = 1; //same as  above
        
        for(int ind = n-1;ind >= 0;ind--){
            int pick1 = s.charAt(ind) - '0'; // this will  actually give us the integer of the first digit
            int pick2 = 0;
            if(ind < s.length()-1){
               pick2 = pick1 * 10 + s.charAt(ind+1) - '0'; //this will give us the value in int for the first two numbers 
            } 
            
            if(pick1 > 0) dp[ind] += dp[ind+1];
        
            if(pick1 > 0 && pick2 > 0 && pick2 <= 26 ) dp[ind] += dp[ind+2]; //ex - "06" remains when we apply our code pick1 will give 0, and pick2 will give 6 and return 1,but its wrong .. so we check if pick1 > 0 or not.
        }
        return dp[0];
    }
}