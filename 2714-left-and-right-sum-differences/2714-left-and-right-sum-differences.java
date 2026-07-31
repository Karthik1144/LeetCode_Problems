class Solution {
    public int[] leftRightDifference(int[] nums) {
        int prefix[] = new int[nums.length];
        int totSum = 0;
        for(int i=0;i<nums.length;i++){
            totSum  += nums[i];
            prefix[i] = totSum;
        }
        int ans[] = new int[nums.length];
        ans[0] = totSum - nums[0];
        for(int i=1;i<nums.length;i++){
            int leftSum = totSum - prefix[i];
            ans[i] = Math.abs(prefix[i-1] - leftSum);
        }
        return ans;
    }
}