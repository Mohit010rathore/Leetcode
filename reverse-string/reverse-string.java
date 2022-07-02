class Solution {
    public void reverseString(char[] s) {
      
     reverse(s,0);

    }
    public void reverse(char[] s, int idx)    // suppose this would swap all the elements of array from idx to length-1-idx
    {
        // base case
        if(idx >= s.length/2)   // when there no elements left to swap
            return;
        
        // Induction
        reverse(s, idx+1);    // assume this would swap all the elements except the first and last
        
        // now I manually swap my first and last element
        char ch = s[idx];
        s[idx] = s[s.length-1-idx];
        s[s.length-1-idx] = ch;
    }
}
    