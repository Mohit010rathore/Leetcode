//class Solution {
    // public String reverseWords(String s) {
//         int  i=s.length()-1;
        
//         StringBuilder res= new StringBuilder("");
        
//         while(i >= 0){
//             while(i >= 0 && s.charAt(i) == ' '){
//                 i--;
//             }
//             int j = i;
            
//             if(i < 0){
//                 break;
//             } 
//             while(i >= 0 && s.charAt(i) != ' '){
//                 i--;
//             }
            
//             if(res.isEmpty()){
//                 res = res.append(s.substring(i+1,j+1));
//             }else{
//                 res = res.append(" " + s.substring(i+1,j+1));
//             }
//         }
//         return res.toString();
        
//     }
class Solution {
    public String reverseWords(String s) {
        String result = new String();
        int start=0;
        int n=s.length();
        while(start<n){
            while(start<n && s.charAt(start)== ' ')
                start++;
            if(start>=n)
                break;
            int end = start+1;
            while(end<n && s.charAt(end)!= ' ')
                end++;
            String sub = s.substring(start,end);
            if(result.length()==0)
                result = sub;
            else
                result = sub + " " + result;
            start = end+1;
        }
        return result;
    }

}