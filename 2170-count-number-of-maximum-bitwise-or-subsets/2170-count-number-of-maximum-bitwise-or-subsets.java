class Solution {
    int maxXor = Integer.MIN_VALUE;
    public int countMaxOrSubsets(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        subSet(0,nums,0,map);
        return map.get(maxXor);
    }
    public void subSet(int ind,int[] nums,int currXor,HashMap<Integer,Integer> map){
        if(ind == nums.length){
            if(maxXor<currXor){
                maxXor = currXor;
                map.put(maxXor,1);
            }
            else if(maxXor == currXor){
                map.put(currXor,map.get(currXor)+1);
            }
            return ;
        }

        subSet(ind+1,nums,currXor|nums[ind],map);
        subSet(ind+1,nums,currXor,map);

        return;
    }
}