class Solution {
    public int smallestIndex(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(i==sumOfDigits(nums[i]))
                ans = Math.min(ans,i);
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
    public int sumOfDigits(int num){
        int sum = 0;
        while(num>0){
            int d = num%10;
            sum += d;
            num /= 10;
        }
        return sum;
    }
}