class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        HashSet<List<Integer>> ans = new HashSet<>();
        combinations(k,n,1,new ArrayList<>(),ans);
        return new ArrayList<>(ans);
    }
    public void combinations(int k ,int n,int index, 
        List<Integer> lst,HashSet<List<Integer>> ans){
        if(index>9){
            if(lst.size()==k && n==0)
                ans.add(new ArrayList<>(lst));
            return;
        }
        lst.add(index);
        combinations(k,n-index,index+1,lst,ans);
        lst.remove(lst.size()-1);
        combinations(k,n,index+1,lst,ans);
    }
}