class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hash = new HashSet<Integer>();
        for(int num : nums){
            hash.add(num);
        }
        
        int longestStreak = 0;
        
        for(int num: nums){
            if(!hash.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;
                
                while(hash.contains(currentNum+1)){
                    currentNum += 1; //keep on increassing the current num --> 1- 1+1=2 -> 2 + 1 =3
                    currentStreak += 1;
                }
                
                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
        
    }
}