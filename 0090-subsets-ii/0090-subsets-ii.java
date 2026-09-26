class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> ans = new HashSet<>();
        generateSubsets(nums,0,ans,new ArrayList<>());
        return new ArrayList<>(ans);
    }
    public void generateSubsets(int nums[],int ind,
        HashSet<List<Integer>> ans,  List<Integer> l){

        if(ind == nums.length ){
            ans.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[ind]);
        generateSubsets(nums,ind+1,ans,l);
        l.remove(l.size()-1);
        generateSubsets(nums,ind+1,ans,l);
    }
}