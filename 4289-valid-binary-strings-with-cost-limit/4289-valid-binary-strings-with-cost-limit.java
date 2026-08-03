class Solution {
    public List<String> generateValidStrings(int n, int k) {
        HashSet<String> set = new HashSet<>();
        helper(0,0,new StringBuilder(),n,k,set);
        return new ArrayList<>(set);       
    }
    void helper(int ind,int c , StringBuilder s,int n,int k,HashSet<String> set){
        if(ind == n){
            if(isValid(s.toString()) && c<=k){
                set.add(s.toString());
            }
            return;
        }
        s.append("0");
        helper(ind+1,c,s,n,k,set);
        s.deleteCharAt(s.length()-1);

        s.append("1");
        helper(ind+1,c+ind,s,n,k,set);
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