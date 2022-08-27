class Solution {
    public int minCost(String colors, int[] neededTime) {
        char c = '*'; //initially taken '*'
        int lastTime = 0;
        int ans = 0;
        
        for(int i = 0;i<colors.length();i++){
            
            if(colors.charAt(i) == c){    //if the prev character is same
                
                if(lastTime < neededTime[i]){    //and the Time required in prev is less than current time, we just add the lasttime in our ans and update our lastTime
                    ans += lastTime;
                    lastTime = neededTime[i];
                }
                else    //if time in prev is greater , we add the current time in our ans
                {   
                    ans += neededTime[i];
                }
            }
            else    //if the prev character is not same , we just update our lastTime and character c
            {
                c = colors.charAt(i);
                lastTime = neededTime[i];
            }
        }
        return ans;
    }
}