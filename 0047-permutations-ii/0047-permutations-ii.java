class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generatePermutations(nums,0,ans);
        return ans;
    }
    public void generatePermutations(int nums[],int ind,List<List<Integer>> ans){
        if(ind==nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int num:nums)
                ds.add(num);
            if(!ans.contains(ds))
                ans.add(new ArrayList<>(ds));
        }
        for(int i=ind;i<nums.length;i++){
            swap(nums,i,ind);
            generatePermutations(nums,ind+1,ans);
            swap(nums,i,ind);
        }
    }
    public void swap(int nums[],int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}