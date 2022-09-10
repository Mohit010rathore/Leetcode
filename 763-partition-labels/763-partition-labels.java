class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        int []endIndex = new int[26];
        
        for(int i = 0 ;i < s.length();i++){
            endIndex[s.charAt(i)-'a'] = i;
        }
        
        int i = 0; //start pointer
        while(i < s.length()){
            char startChar = s.charAt(i);
            int terminalIndex = endIndex[startChar - 'a']; //terminal index-> at what  place that character ends
            //and it will store the end of the terminal as we move ahead
            
            for(int j = 0;j <= terminalIndex;j++){
                terminalIndex = Math.max(terminalIndex,endIndex[s.charAt(j) - 'a']);
            }
            
            list.add(terminalIndex - i + 1);
            i = terminalIndex + 1;
            
        }
        return list;
    }
}