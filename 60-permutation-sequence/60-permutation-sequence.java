class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        
        //factorial 
        for(int i =1;i<n;i++){
            fact = fact * i;
            //storing all the numbers {1,2,3}
            numbers.add(i);
        }
        //storing the last number here {1,2,3,4}
        numbers.add(n);
        
        //we have to return ans in a string 
        String ans = "";
        
        //as we are considering 0-based indexing
        //k = 17
        //k = 17-1 = 16
        k = k-1;
        
        //running an infinite loop
        while(true){
            
            //16(k) / 6(3!) = 2nd index number = 3-> we pick out and add to our ans
            ans = ans + numbers.get(k/fact);
            
            //remove this 3 to get the new array {1,2,4}
            numbers.remove(k/fact);
            
            //till the list is empty
            if(numbers.size() == 0){
                break;
            }
            
            //16(k) % 6{fact 3!}
            k = k % fact ;
            
             // 6 / 3 = 2 (new numbers array size)
            fact = fact / numbers.size();
            
            //doing these tasks every time till the numbers list becomees empty we break and return ans
        }
        return ans;
    }
}