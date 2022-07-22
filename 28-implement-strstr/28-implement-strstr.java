class Solution {
    public int strStr(String haystack, String needle) {
        
        int len1 = haystack.length();
        int len2 = needle.length();

        if(len1 < len2){
            return -1;
        }
        
        for(int i =0;i<= len1-len2 ;i++){   
        int j;
                for(j=0;j<len2;j++){
                    if(haystack.charAt(i+j) != needle.charAt(j)){
                        break;
                    }
                }
                if(j == len2) return i;
        }
        return -1;
        
    }
}