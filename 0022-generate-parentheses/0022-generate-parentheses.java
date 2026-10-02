class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(0,0,"",ans,n);
        return ans;
    }
    public void generate(int openCount,int endCount,String curr,List<String> ans , int n){
        if(curr.length() == n*2){
            ans.add(curr);
            return;
        }
        if(openCount<n)
            generate(openCount+1,endCount,curr+"(",ans,n);
        if(endCount<openCount)
            generate(openCount,endCount+1,curr+")",ans,n);
    }
}