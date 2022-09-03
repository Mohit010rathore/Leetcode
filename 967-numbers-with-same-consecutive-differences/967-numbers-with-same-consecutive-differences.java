/*

Approach:

First put integer from 1-9(as leading 0 is not allowed) at the first place of the non-negative result integer and then check whether the next digit can have +k and -k values, if so then make recursion call for next item

Let's understand the example:
let n=3, k=7

now our number will have three digits -->   _ _ _
put integers from 1-9 on first place and
check for next digits
                        
i=1                     1 _ _
for 2nd digit 1+7=8(allowed) and 1-7=-6(not allowed)
so          -->         1 8 _
for 3rd digit 8+7=15(not allowed) and 8-7=1(allowed)
so          -->         1 8 1


i=2         -->         2 _ _
for 2nd digit 2+7=9(allowed) and 2-7=-5(not allowed)
so          -->         2 9 _
for 3rd digit 9+7=16(not allowed) and 9-7=2(allowed)
so          -->         2 9 2


i=3         -->         3 _ _
for 2nd digit 3+7=10(not allowed) and 3-7=-4(not allowed)
hence not solve further 

same in case of i=4,5,6


i=7         -->         7 _ _
for 2nd digit 7+7=14(not allowed) and 7-7=0(allowed)
so          -->         7 0 _
for 3rd digit 0+7=7(allowed) and 0-7=-7(not allowed)
so          -->         7 0 7

and so on...


*/

class Solution {
    List<Integer> res;
    public int[] numsSameConsecDiff(int n, int k) {
        res = new ArrayList<>();
        
        // Taking all possible cases for first digit from 1-9
        for(int i=1; i<=9; i++)solve(i,1,n,k);
        
        // Converting List to Array
        int len = res.size();
        int[] arr  = new int[len];
        for(int i=0; i<len; i++)arr[i] = res.get(i);
        return arr;
    }
    
    private void solve(int item, int i, int n, int k){
        if(i==n){
            res.add(item);
            return;
        }
        
        // To check for +k and -k results with the last digit
        int a = item % 10;
        
        // If the absolute difference is zero, then should be single recursive call else there will be duplicate values in the result
        if(k == 0){
            int temp = (item*10) + a;
            solve(temp,i+1,n,k);
        }
        else{
            
            // Check for +k and -k values and proceed accordingly
            if((a+k)<=9){
                int temp = (item*10) + (a+k);
                solve(temp,i+1,n,k);
            }
            if((a-k)>=0){
                int temp = (item*10) + (a-k);
                solve(temp,i+1,n,k);
            }    
        }
        
    }
}