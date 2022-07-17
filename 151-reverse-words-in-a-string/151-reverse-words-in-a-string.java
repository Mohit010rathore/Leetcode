class Solution {
    public String reverseWords(String s) {
        int  start=s.length()-1; //we started from the last
        
        StringBuilder res= new StringBuilder("");
        
        while(start >= 0){
            while(start >= 0 && s.charAt(start) == ' '){
                start--;
            }
            int end = start; //here when wee found the character of a word starting from right we assign it to end-it will represent the word ending
            
            if(start < 0){  //when we arrived at first index and still going on after it...this condition will block it to move
                break;
            } 
            while(start >= 0 && s.charAt(start) != ' '){ //and we again move i to find the starting of the word, and store it in start
                start--;
            }
            
            if(res.isEmpty()){
                res = res.append(s.substring(start+1,end+1));  //starting from -1 bcoz i is on space and j+1 to include the whole word.
            }else{
                res = res.append(" " + s.substring(start+1,end+1));  //concat with space
            }
        }
        return res.toString();
        
    }
}
// class Solution {
//     public String reverseWords(String s) {
//         int start = s.length()-1;
        
//         String ans ="";
//         while(start >= 0){
//             while(start >= 0 && s.charAt(start) == ' '){
//                 start--;
//             }
//             int end = start;
            
//             while(start >= 0 && s.charAt(start) == ' '){
//                 start--;
//             }
            
//             if(start < 0) break; //when we arrived at first index and still going on after it...this condition will block it to move
            
//             if(ans.isEmpty()){
//                 ans = ans.concat(s.substring(start+1,end+1)); //starting from -1 bcoz i is on space and j+1 to include the whole word.
//             }else{
//                 ans = ans.concat(" " + s.substring(start+1,end+1)) ;//concat with space
//             }
//         }
//         return ans;
//     }

// }