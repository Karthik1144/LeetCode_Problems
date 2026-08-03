class Solution {
    public List<String> generateValidStrings(int n, int k) {
        ArrayList<String> ans = new ArrayList<>();
        helper(0,0,false,new StringBuilder(),n,k,ans);
        return ans;       
    }
    void helper(int ind,int c , boolean prevOne, StringBuilder s,int n,int k,ArrayList<String> ans){
        if(c>k)
            return;

        if(ind == n){
            ans.add(s.toString());
            return;
        }

        s.append("0");
        helper(ind+1,c,false,s,n,k,ans);
        s.deleteCharAt(s.length()-1);

        if(!prevOne){
            s.append("1");
            helper(ind+1,c+ind,true,s,n,k,ans);
            s. deleteCharAt(s.length()-1);
        }
    }
    
}