class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int left = 0 , right = nums.length-1, j = nums.length-1;
        int arr[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot)
                arr[left++] = nums[i];
            if(nums[j-i]>pivot)
                arr[right--] = nums[j-i];
        }
        while(left<=right)
            arr[left++] = pivot;
        return arr;
    }
}