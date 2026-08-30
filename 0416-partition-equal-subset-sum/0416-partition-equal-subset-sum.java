class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totSum = 0;
        for(int num:nums)
            totSum += num;

        if(totSum%2 !=0 )
            return false;

        int k = totSum/2;

        boolean dp[][] = new boolean[n][k+1];

        dp[0][0] = true;
        if(nums[0]<=k)
            dp[0][nums[0]] = true;

        for(int i=1;i<n;i++){
            for(int t=0;t<=k;t++){
                boolean notTake = dp[i-1][t];

                boolean take = false;
                if(nums[i]<=t)
                    take = dp[i-1][t-nums[i]];

                dp[i][t] = notTake | take; 
            }
        }

        return dp[n-1][k];
    }
}