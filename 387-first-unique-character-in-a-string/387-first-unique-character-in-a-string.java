// class Solution {
//     static final int CHAR = 256;
//     public int firstUniqChar(String s) {
//         int fI[] = new int [CHAR];
//         Arrays.fill(fI,-1);
        
//         for(int i=0;i<s.length();i++){
//             if(fI[s.charAt(i)] == -1)
//             {
//                 fI[s.charAt(i)] = i;
//             }else
//             {
//                 fI[s.charAt(i)] = -2;
//             }
//         }
//         int res = Integer.MAX_VALUE;
//         for(int i=0;i<CHAR;i++){
//             if(fI[i] >= 0){
//                 res = Math.min(res,fI[i]);
//             }
//         }
//         return (res == Integer.MAX_VALUE) ? -1 : res;
//     }
// }
class Solution {
    public int firstUniqChar(String s) {
        int [] freq = new int[26];
        
        for(int i =0;i <s.length();i++){
            freq[s.charAt(i) - 'a'] ++;
            
        }
        
        for(int i =0;i<s.length() ;i++){
            if(freq[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
        
    }
}


// class Solution {
//     private static final int SIZE=26;
//     public int firstUniqChar(String s) {
//        int freq[]=new int[SIZE];
//         for(int i=0;i<s.length();i++){
//             freq[s.charAt(i)-'a']++;
//         }
//         for(int i=0;i<s.length();i++){
//             if(freq[s.charAt(i)-'a']==1)
//                 return i;
//         }
//         return -1;
//     }
// }