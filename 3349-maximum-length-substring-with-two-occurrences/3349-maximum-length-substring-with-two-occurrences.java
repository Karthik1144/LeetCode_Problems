class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int start = 0 , maxLen = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);

            while(start<=i && map.get(ch)>2){
                char left = s.charAt(start);
                map.put(left,map.get(left)-1);
                start++;
            }

            maxLen = Math.max(maxLen,i-start+1);
            // System.out.println(s.substring(start,maxLen+1));
        }
        return maxLen;
    }
}