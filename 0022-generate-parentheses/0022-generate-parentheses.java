class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateAll(n,0,0,"",result);
        return result;
    }
    public void generateAll(int n, int open,int close,String s,List<String> result){
        if(s.length()==n*2){
            result.add(s);
            return;
        }
        if(open<n)
            generateAll(n,open+1,close,s+"(",result);
        if(close<open)
            generateAll(n,open,close+1,s+")",result);
    }
}