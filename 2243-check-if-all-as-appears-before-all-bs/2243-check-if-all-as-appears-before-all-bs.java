class Solution {
    public boolean checkString(String s) {
        int aCount = 0 , bCount = 0;
        for(int i=0;i<s.length();i++){
            if(bCount>0 && s.charAt(i) == 'a'){
                return false;
            }
            if(s.charAt(i) == 'a')
                aCount++;
            else
                bCount++;
        }
        return true;
    }
}