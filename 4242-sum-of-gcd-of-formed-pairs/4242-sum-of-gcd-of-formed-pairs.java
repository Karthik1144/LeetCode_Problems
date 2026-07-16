class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n];

        int mx = 0;
        for(int i=0;i<n;i++){
            mx = Math.max(mx,nums[i]);
            prefix[i] = gcd(nums[i],mx);
        }
        Arrays.sort(prefix);
        int  i=0, j=n-1;
        long sum = 0;
        while(i<j){
            sum += gcd(prefix[i],prefix[j]);
            i++;j--;
        }
        return sum;
    }
    public int gcd(int a,int b){
        while( b!=0){
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a; 
    }
}