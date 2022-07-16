class Solution {
    public int countSubstrings(String s) {
        int dp[][] = new int [s.length()][s.length()];
        int count = 0;
        
        for(int diff = 0;diff<s.length();diff++){
            for(int i =0,j = diff;j<s.length();i++,j++){
                
                if(diff == 0){  //for every 0 gap/diff  diagonal we put true/1.
                    dp[i][j] = 1;
                }
                else if(diff == 1){  // if diff/gap  == 1
                    if(s.charAt(i) == s.charAt(j)){  
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = 0;
                    }
                }
                else{
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i+1][j-1];
                    }else{
                        dp[i][j] = 0;
                    }
                }
                if(dp[i][j] == 1) count++;
            }
        }
        return count;
    }
}