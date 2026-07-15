class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumodd = n*n;
        int sumeven = n*(n+1);
        return gcd(sumodd,sumeven);
    }
    public static int gcd(int a,int b){
        while(a!=0 && b!=0){
            if(a>=b)
                a = a%b;
            else 
                b = b%a; 
        }
    return a==0? b:a;
    }
}