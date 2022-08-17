class Solution {
     public double myPow(double x, int n) {
         //checking if our 
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return helper(x, N);
    }
     private double helper(double x, long n) {
         
//         double xnm1 = myPow(x,n-1);
//         double xn = x * xnm1;
        
//         return xn;
                
        if (n == 0) {
            return 1.0;
        }
        double xpnb2 = helper(x, n / 2);
        if (n % 2 == 0) {
            return xpnb2 * xpnb2;
        }
        else {
            return xpnb2 * xpnb2 * x;
        }
    }
}

