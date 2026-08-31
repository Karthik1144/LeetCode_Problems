class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() ==1)
            return s.length();

        HashMap<Character,Integer> map = new HashMap<>();
        int  start = 0 , maxLen = 1;  
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                start = Math.max(start,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            maxLen = Math.max(maxLen,i-start+1);
        }
        return maxLen;
    }
}