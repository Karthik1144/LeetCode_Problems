class Solution {
    public int jump(int[] nums) {
        int jumps = 0 , currIndex = 0 , farthest = 0;
        for(int i=0;i<nums.length-1;i++){
            farthest = Math.max(i+nums[i],farthest);

            if(i == currIndex){
                currIndex = farthest;
                jumps++;
            }
        }
        return jumps;
    }
}