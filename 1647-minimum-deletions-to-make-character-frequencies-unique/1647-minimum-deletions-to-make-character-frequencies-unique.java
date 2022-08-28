class Solution {
    public int minDeletions(String s) {
        int deletion = 0;
        
        int [] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
            
        }
        
        Set<Integer> uniqueFrequencies = new HashSet<Integer>();
        
        for(int count : freq){
            while(count > 0 && uniqueFrequencies.contains(count)){
                deletion++;
                count--;
            }
            uniqueFrequencies.add(count);
        }
        return deletion;
    }
}