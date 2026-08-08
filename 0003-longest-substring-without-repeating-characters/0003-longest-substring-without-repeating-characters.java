class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLen = 0 ,start = 0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                start = Math.max(start,map.get(ch)+1);
            }
            map.put(ch,i);
            maxLen = Math.max(maxLen,i-start+1);
        }
        return maxLen;
    }
}