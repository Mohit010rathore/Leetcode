class Solution {
    public int mySqrt(int x) {
        int ans = 0;
        int start = 1;
        int end = x;
        while(start <= end){
            long mid = start + (end - start)/2;
            long midSqr = mid*mid;
            if(midSqr == x){
                return (int)mid;
            }else if(midSqr > x){
                end = (int)mid - 1;
            }else{
                ans = (int)mid;
                start = (int)mid + 1;
            }
        }
        return ans;
    }
}