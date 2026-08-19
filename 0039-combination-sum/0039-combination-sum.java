class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(candidates,0,target,ans,new ArrayList<>());
        return ans;
    }
    public void findCombinations(int []candidates,int ind,int target,          List<List<Integer>> ans,List<Integer> lst){
        if(ind==candidates.length){
            if(target==0)
                ans.add(new ArrayList<>(lst));
            return;
        }
        if(candidates[ind]<=target){
            lst.add(candidates[ind]);
            findCombinations(candidates,ind,target-candidates[ind],ans,lst);
            lst.remove(lst.size()-1);
        }
        findCombinations(candidates,ind+1,target,ans,lst);
    }
}