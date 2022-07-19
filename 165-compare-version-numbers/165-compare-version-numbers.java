class Solution {
    public int compareVersion(String version1, String version2) {
        int v1Length = version1.length();
        int v2Length = version2.length();
        int n1,n2;
        
        int i=0;
        int j=0;
        
        while(i< v1Length || j< v2Length){
            n1 = 0;
            n2 = 0;
            while(i < v1Length && version1.charAt(i) != '.'){
                n1 = n1 * 10 + (version1.charAt(i) - '0');  // '4' - '2' = 2 -> will convert character into integer form
                i++;
            }
        
            while(j < v2Length && version2.charAt(j) != '.'){
                n2 = n2 * 10 + (version2.charAt(j) - '0');          
                j++;
            }
            
            if(n1 > n2) return 1;
            else if(n1 < n2) return -1;
            
            //we are incrementing bcoz when the while loop breaked we are at the revision(.) so we have to move forward to the next digit
            
            i++;
            j++;
        }
        return 0;
    }
}