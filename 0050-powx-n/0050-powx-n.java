class Solution {
    public double myPow(double x, int n) {
        long N = n;
       if(N<0){
            return 1.0/power(x,-N);
       }
       return power(x,N);
    }
    public double power(double x, long n){
         // Base case: anything raised to 0 is 1
        if (n == 0) 
            return 1.0;
        
        // Base case: anything raised to 1 is itself
        if (n == 1) 
            return x;

        if(n%2==0)
            return power(x*x,n/2);
        
        return  x*power(x,n-1);
    }
}