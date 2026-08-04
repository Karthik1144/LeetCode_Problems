class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int num:nums){
            set.add(num);
            if(num<min)
                min = num;
            if(num>max)
                max = num;
        }
        List<Integer> lst = new ArrayList<>();
        for(int i=min;i<=max;i++){
            if(!set.contains(i))
                lst.add(i);
        }
        return lst;
    }
}