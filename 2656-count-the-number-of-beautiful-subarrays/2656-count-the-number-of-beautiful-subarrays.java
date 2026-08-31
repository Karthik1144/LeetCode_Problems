class Solution {
    public long beautifulSubarrays(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int xor = 0  ;
        long count = 0;
        for(int i=0;i<nums.length;i++){
            xor ^= nums[i];
            if(map.containsKey(xor))
                count += map.get(xor);

            map.put(xor,map.getOrDefault(xor,0)+1);
        }
        return count;
    }
}