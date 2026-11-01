class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            long pro = 1;
            for(int j=i;j<nums.length;j++){
                pro = pro*nums[j];
                if(pro>=k)
                    break;
                count++;
            }
        }
        return count;
    }
}