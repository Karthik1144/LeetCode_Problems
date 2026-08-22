class Solution {
    public int subsetXORSum(int[] nums) {
        int[] ans = {0};        
        subSet(0,nums,0,ans);
        return ans[0];
    }
    public void subSet(int ind,int nums[],int currXor,int[] ansXor){
        if(ind == nums.length){
            ansXor[0] += currXor;
            return;
        }

        subSet(ind+1,nums,currXor^nums[ind],ansXor);
        subSet(ind+1,nums,currXor,ansXor);
    }
}