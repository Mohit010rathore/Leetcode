class Solution {
    public int partitionString(String s) {
        int count = 0;
        
        Set<Character> set = new  HashSet<>();
        for(char c : s.toCharArray()){
            //when we found that the character not exist in map->we add into map and if already existed in map,
            //then we decide to make partion -so we increment count
            //and when moving to next iteration we create the new hashset to store and
            //perform the similar operations
            if(set.contains(c)){
                count++;
                
                //reset
                set = new HashSet<>();
                set.add(c);
            }else{
                set.add(c);
            }
            
        }
        //if any element remained -> the count of partion should be incremented
        if(!set.isEmpty()) count++;
        return count;
        
    }
}