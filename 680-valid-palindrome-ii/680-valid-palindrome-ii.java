class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length()-1 ;
        while(end > start){
            if(s.charAt(start) != s.charAt(end)){
                return validPalindromeHelper(s,start + 1,end) || validPalindromeHelper(s,start,end-1);
            }
            start ++;
            end--;
        }
        return true;
    }
    
    private boolean validPalindromeHelper(String s,int start,int end){
        while(end > start){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    } 
}