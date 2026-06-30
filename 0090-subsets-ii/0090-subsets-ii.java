class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        generateSubsets(nums,0,set,new ArrayList<>());
        // System.out.println("Inside the set: ");
        for(List lst:set){
            // System.out.println(lst);
            ans.add(lst);
        }
        return ans;
    }
    public void generateSubsets(int nums[],int ind,HashSet<List<Integer>> set,  List<Integer> l){
        if(ind == nums.length ){
            // System.out.println(l);
            set.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[ind]);
        generateSubsets(nums,ind+1,set,l);
        l.remove(l.size()-1);
        generateSubsets(nums,ind+1,set,l);
    }
}