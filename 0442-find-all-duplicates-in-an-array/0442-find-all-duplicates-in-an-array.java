class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int hash[] = new int[nums.length+1];
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(hash[nums[i]] == 1)
                ans.add(nums[i]);
            else
                hash[nums[i]] = 1;
        }
        return ans;
    }
}