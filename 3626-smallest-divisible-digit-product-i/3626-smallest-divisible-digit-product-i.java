class Solution {
    public int smallestNumber(int n, int t) {
        int  i = n;
        while(true){
            if(digitProduct(i)%t==0)
                return i;
            i++;
        }
        // return -1;
    }
    public int digitProduct(int num){
        int ans = 1;
        while(num>0){
            int d = num%10;
            ans = ans*d;
            num = num/10;
        }
        return ans;
    }
}