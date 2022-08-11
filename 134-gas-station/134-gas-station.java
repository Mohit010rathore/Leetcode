class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int totalCost = 0;
        int totalGas = 0;
        
        for(int i =0;i<gas.length;i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        
        if(totalGas < totalCost){
            return -1;
        }
        
        //finding where to start
        int remainingGas = 0;
        int start = 0;
        for(int i =0;i<gas.length;i++){
            remainingGas += gas[i] - cost[i];
            //any timme our gas becomes negative - we know that the selected start is not our ans so we 
            //move to i(where, when our gas becomes 0) + 1
            if(remainingGas < 0){
                start = i+1;
                remainingGas = 0;
            }
        }
        return start;
    }
}