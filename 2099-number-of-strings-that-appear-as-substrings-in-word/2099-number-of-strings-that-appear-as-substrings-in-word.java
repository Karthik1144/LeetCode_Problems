class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for(int i=0;i<patterns.length;i++){
            String pattern = patterns[i];
            if(word.contains(pattern)){
                count++;
            }
        }
        return count;
    }
}