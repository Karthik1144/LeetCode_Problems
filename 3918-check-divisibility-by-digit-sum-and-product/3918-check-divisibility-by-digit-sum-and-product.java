class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0 , pro = 1,temp=n;
        while(n>0){
            int d = n%10;
            sum += d;
            pro *= d;
            n /= 10;
        }
        // System.out.println(sum+pro);
        if(temp%(sum+pro)==0)
            return true;
        return false;
    }
}