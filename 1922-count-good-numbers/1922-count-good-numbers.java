class Solution {
    public int countGoodNumbers(long n) {
        long mod = (long)1e9+7;

        long even = (n+1)/2;
        long odd = n/2;

        long ans = Power(5,even);
        ans = (ans * Power(4,odd)) % mod;

        return (int)ans;
    }
    public long Power(long base,long exp){
        if(exp == 0)
            return 1;

        if(exp==1)
            return base;

        long mod = (long) 1e9+7;

        if(exp%2==0)
            return Power((base*base)%mod,exp/2);

        return (base*Power(base,exp-1))%mod;
    }
}