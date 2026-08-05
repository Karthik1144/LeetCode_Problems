class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0 ,right = nums.length-1;
        int l = -1, r = -1;
        while(left<=right){
            int mid = left + (right-left)/2;

            if(nums[mid]==target){
                l = mid;
                right = mid-1;
            }
            else if(nums[mid]<target)
                left = mid+1;
            else 
                right = mid-1;
        }
        left = 0;
        right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;

            if(nums[mid] == target){
                r = mid;
                left = mid+1;
            }
            else if(nums[mid] < target)
                left = mid+1;
            else 
                right = mid-1;
        }
        return new int[]{l,r};
    }
}