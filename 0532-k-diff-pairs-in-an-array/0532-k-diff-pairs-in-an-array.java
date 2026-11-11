class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        HashSet<String> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]  - nums[i] == k ){
                    String pair = nums[i] + "," + nums[j];
                    set.add(pair);
                }
            }
        }
        return set.size();
    }
}