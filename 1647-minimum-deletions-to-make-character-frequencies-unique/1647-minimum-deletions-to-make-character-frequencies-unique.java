class Solution {
    public int minDeletions(String s) {
        
        int deletion = 0; //to store the number pf deletions
        
        int [] freq = new int[26];
        
        //storing the frequencies of all character in  an array
        for(char c : s.toCharArray()){
            freq[c-'a']++;
            
        }
        
        //Set will onlt contain the unique frequencies which is integer
        Set<Integer> uniqueFrequencies = new HashSet<Integer>();
        
        for(int count : freq){
            
            //if set contain the same frequency integer we do deletion++ and count of frequency--
            //and if the frequency is unique we come out of while loop and add that uniqueFrequenct count in set
            while(count > 0 && uniqueFrequencies.contains(count)){
                deletion++;
                count--;
            }
            uniqueFrequencies.add(count);
        }
        return deletion;
    }
}