class Solution {

    // Refer to the notes

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++)
            set.add(nums[i]);

        int max = 1;
        for(int num:set){
            if(!set.contains(num-1)){
                int val = num , cnt =1;
                while(set.contains(val+1)){
                    cnt ++;
                    val = val+1;
                }
                max = Math.max(cnt,max);
            }
        }
       return max;
    }
}