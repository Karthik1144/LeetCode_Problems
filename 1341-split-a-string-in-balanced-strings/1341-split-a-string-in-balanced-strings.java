class Solution {
    public int balancedStringSplit(String s) {
        int ans = 0 , lcount = 0 , rcount = 0;
        for(char ch:s.toCharArray()){
            if(ch=='L')
                lcount++;
            else 
                rcount++;

            if(lcount == rcount){
                ans++;
                lcount = 0;
                rcount = 0;
            }
        }
        return ans;
    }
}