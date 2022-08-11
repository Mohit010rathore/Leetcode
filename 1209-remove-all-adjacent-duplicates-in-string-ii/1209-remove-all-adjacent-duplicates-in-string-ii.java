class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(stack.isEmpty() || stack.peek().c != c) {
                stack.push(new Pair(c, 1));
            } else {
                stack.push(new Pair(c, stack.peek().count+1));
            }
              
            if(!stack.isEmpty() && stack.peek().count == k) {
                int temp = k;
                while(temp-- > 0) {
                    stack.pop();
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop().c);
        }
        
        return sb.reverse().toString();
    }
}

public class Pair {
    public char c;
    public int count;

    public Pair(char c, int count) {
        this.c = c;
        this.count = count;
    }
}