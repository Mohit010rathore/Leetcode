class Solution {
    public String decodeString(String s) {
        Stack<Integer> freqStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        
        //to store our currr cache string value
        StringBuilder currStr = new StringBuilder();
        //to store freq
        int k= 0;
        
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                k = k * 10 + (c - '0');
            }else if(Character.isLetter(c)){
                currStr.append(c);
            }else if(c == '['){
                freqStack.push(k);
                strStack.push(currStr);
                
                //reset these value
                currStr = new StringBuilder();
                k = 0;
            }else if(c == ']'){
                StringBuilder temp = currStr;
                int freq = freqStack.pop();
                currStr = strStack.pop();
                
                while(freq-- > 0){
                    currStr.append(temp);
                    
                }
                k = 0;
            }
        }
        return currStr.toString();
    }
}