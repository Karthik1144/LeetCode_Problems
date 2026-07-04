class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int hash[] = new int[101];
        for(int i=0;i<nums.length;i++)
            hash[nums[i]]++;

        int target = nums[nums.length/2];
        return hash[target]==1 ? true : false;
    }
}