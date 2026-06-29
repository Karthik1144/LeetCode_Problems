class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0 || nums.length==1)
            return nums.length;

        HashSet<Integer> set = new HashSet<>();
        for(int num:nums)
            set.add(num);

        int longest = 1;
        for(int val:set){
            if(!set.contains(val-1)){
                int count = 1 , x = val;
                while(set.contains(x+1)){
                    count++;
                    x = x+1;
                }
                longest = Math.max(longest,count);
            }
        }
        return longest;
    }
}