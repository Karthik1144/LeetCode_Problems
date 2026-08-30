class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totSum = 0 ;
        for(int i=0;i<nums.length;i++)
            totSum += nums[i];

        if((totSum+target)%2!=0 || Math.abs(target) > totSum)
            return 0;
        
        int newTarget = (totSum+target)/2;

        return findCount(nums,newTarget);
    }
    public int findCount(int nums[],int target){
        int n = nums.length;
        int dp[][] = new int[n][target+1];

        if(nums[0] == 0)
            dp[0][0] = 2;
        else{
            dp[0][0] = 1;

            if(nums[0]<=target)
                dp[0][nums[0]] = 1;
        }


        for(int i=1;i<n;i++){
            for(int t=0;t<=target;t++){
                int notTake = dp[i-1][t];

                int take = 0;
                if(nums[i]<=t)
                    take = dp[i-1][t-nums[i]];

                dp[i][t] = take+notTake; 
            }
        }
        return dp[n-1][target];
    }
}