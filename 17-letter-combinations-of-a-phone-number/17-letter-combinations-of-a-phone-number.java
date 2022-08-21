class Solution {
    void solve(String digits, String out, List<String> ans, int ptr,String[] mapping){
            //base case
            if (ptr >= digits.length()){
                ans.add(out);
                return;
            }

            int element = digits.charAt(ptr) - '0';
            String value = mapping[element];
            //recursive call
            for(int i = 0; i < value.length(); i++){
                out += value.charAt(i);
                solve(digits, out, ans, ptr+1, mapping);
                out = out.substring(0, out.length() -1);
            }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList();
        if(digits.length() == 0)
            return ans;
        
        int ptr = 0;
        String out = "";
        
        String mapping[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        solve(digits, out, ans, ptr, mapping);
        return ans;
    }
}