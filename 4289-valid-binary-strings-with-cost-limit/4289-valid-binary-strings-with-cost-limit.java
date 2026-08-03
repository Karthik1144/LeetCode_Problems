class Solution {
    public List<String> generateValidStrings(int n, int k) {
        ArrayList<String> ans = new ArrayList<>();
        helper(0,0,new StringBuilder(),n,k,ans);
        return ans;       
    }
    void helper(int ind,int c , StringBuilder s,int n,int k,ArrayList<String> ans){
        if(ind == n){
            if(isValid(s.toString()) && c<=k){
                ans.add(s.toString());
            }
            return;
        }
        s.append("0");
        helper(ind+1,c,s,n,k,ans);
        s.deleteCharAt(s.length()-1);

        s.append("1");
        helper(ind+1,c+ind,s,n,k,ans);
        s.deleteCharAt(s.length()-1);
    }
    boolean isValid(String s){
        for(int i = 0;i<s.length()-1;i++){
            if(s.charAt(i) == '1' && s.charAt(i+1)=='1')
                return false;
        }
        return true;
    }
}