class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] freqTrust = new int[n+1];
        
        for(int[] t : trust){
            freqTrust[t[0]]--;
            freqTrust[t[1]]++;
        }
        
        for(int i =1;i <= n;i++){
            if(freqTrust[i] == n-1) return i;
        }
        return -1;
    }
}