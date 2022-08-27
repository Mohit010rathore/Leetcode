class Solution {
    public int minCost(String colors, int[] neededTime) {
        char c = '*';
        int lastTime = 0;
        int ans = 0;
        
        for(int i = 0;i<colors.length();i++){
            if(colors.charAt(i) == c){
                if(lastTime < neededTime[i]){
                    ans += lastTime;
                    lastTime = neededTime[i];
                }else{
                    ans += neededTime[i];
                }
            }else{
                c = colors.charAt(i);
                lastTime = neededTime[i];
            }
        }
        return ans;
    }
}