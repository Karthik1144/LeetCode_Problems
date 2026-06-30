class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generateSubsets(nums,0,ans,new ArrayList<>());
        return ans;
    }
    public void generateSubsets(int nums[],int ind,List<List<Integer>>ans,List<Integer>l){
        if(ind==nums.length){
            ans.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[ind]);
        generateSubsets(nums,ind+1,ans,l);
        l.remove(l.size()-1);
        generateSubsets(nums,ind+1,ans,l);
    }
}