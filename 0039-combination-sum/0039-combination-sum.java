class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(candidates,target,0,0,new ArrayList<>(),ans);
        return ans;
    }
    public void combination(int[] candidates,int target,int i,int sum,
                                    List<Integer> lst,List<List<Integer>> ans){
        if(i==candidates.length){
            if(sum==target){
                ans.add(new ArrayList<>(lst));
            }
            return;
        }
        if(sum<target){
            lst.add(candidates[i]);
            sum += candidates[i];
            combination(candidates,target,i,sum,lst,ans);
            lst.remove(lst.size()-1);
            sum -= candidates[i];
        }
        combination(candidates,target,i+1,sum,lst,ans);
    }
}