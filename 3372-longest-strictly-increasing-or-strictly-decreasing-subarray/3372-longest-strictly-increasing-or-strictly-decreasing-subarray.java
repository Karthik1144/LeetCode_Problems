class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                max = Math.max(max,find(false,i,j,nums));
                max = Math.max(max,find(true,i,j,nums));
            }
        }
        return max;
    }
    int find(boolean isInc,int start,int end,int nums[]){
        int i = start;
        start++;
        while(start<=end){
            if(isInc){
                if(nums[start]<=nums[start-1])
                    return 0;
            }
            else{
                if(nums[start]>=nums[start-1])
                    return 0;
            }
            start++;
        }
        return end-i+1;
    }
}