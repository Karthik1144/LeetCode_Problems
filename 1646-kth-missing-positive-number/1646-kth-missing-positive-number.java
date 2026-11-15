class Solution {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> set  = new HashSet<>();

        int max = 0;
        for(int num:arr){
            max = Math.max(max,num);
            set.add(num);
        }

        for(int i=1;i<=max;i++){
            if(!set.contains(i))
                k--;

            if(k==0)
                return i;
        }
        while(k!=0){
            k--;
            max++;
        }
        return max;
    }
}