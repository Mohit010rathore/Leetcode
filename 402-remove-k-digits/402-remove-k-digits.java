class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Character> stk = new Stack<>();
        
        for(int i=0; i<num.length(); i++){
            while(stk.size()>0 && k>0 && stk.peek()>num.charAt(i)){
                stk.pop();
                k--;
            }
            
            stk.push(num.charAt(i));
        }
        

        while(k>0){
            stk.pop();
            k--;
        }
        

        System.out.println(stk);
        
        char[] arr = new char[stk.size()];
        int l=arr.length-1;
        while(l>=0){
            arr[l--]=stk.pop();
        }
        
        int d=0;
        while(d<arr.length && arr[d]=='0')d++;
        
        StringBuilder sb = new StringBuilder();
        while(d<arr.length){
            sb.append(arr[d++]);
        }
        if(sb.length()==0){
           sb.append('0');
        }
        
        return sb.toString();
    }
}