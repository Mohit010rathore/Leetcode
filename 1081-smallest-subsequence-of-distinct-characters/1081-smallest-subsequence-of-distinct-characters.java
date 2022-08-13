class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        int [] lastIndex = new  int[26];
        boolean [] seen = new boolean[26];
        
        for(int i=0;i<n;i++){
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        Stack <Integer> st = new Stack<>();
        
        for(int i=0;i<n;i++){
            int curr = s.charAt(i) - 'a';
            
            if(seen[curr]){
                continue;
            }
            
            seen[curr] = true;
            
            while(!st.isEmpty() && st.peek() > curr && i < lastIndex[st.peek()]){
                seen[st.pop()] = false;
            }
            
            st.push(curr);
            
        }
        StringBuilder res = new StringBuilder();
        //using this way of iteration in stack -> we move to bottom to top
        for(int ele : st){
            res.append((char)(ele + 'a'));
        }
        
        return res.toString();
    
    }
}