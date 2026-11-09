class Solution {
    public int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE , max2 = max1 , max3 = max2;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }
            else if(nums[i]<max1 && nums[i]>max2){
                max3 = max2;
                max2 = nums[i];
            }
            else if(nums[i]<max1 && nums[i]<max2 && nums[i]>max3)
                max3 = nums[i];
        }
         return (int)(max3 != Long.MIN_VALUE ? max3 : max1);
    }
}