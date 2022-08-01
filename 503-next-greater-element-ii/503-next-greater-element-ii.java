class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n= nums.length;
        int res [] = new int[n];
        
        Stack<Integer> s = new Stack<>();
        
        for(int i = 2*n -1 ;i >= 0;i--){
            while(s.isEmpty() == false && s.peek() <= nums[i%n]){
                s.pop();
            }
            
            if(i < n){
                if(s.isEmpty() == false) res[i] = s.peek();
                else res[i] = -1;
            }
            
            s.push(nums[i%n]);
        }
        return res;
    }
}