class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>> ans = new HashSet<>();
        combination(candidates, target, 0, new ArrayList<>(), ans);
        return new ArrayList<>(ans);
    }

    public void combination(int[] candidates, int target, int index,
            List<Integer> lst, HashSet<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(lst));
            return;
        }

        if(target<0){
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
                continue;

            if(candidates[i]>target){
                break;
            }

            lst.add(candidates[i]);
            combination(candidates, target-candidates[i], i + 1, lst, ans);
            lst.remove(lst.size() - 1);
        }
    }
}