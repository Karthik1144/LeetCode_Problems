class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int ransomHash[] = new int[26];
        for(char ch:ransomNote.toCharArray()){
            ransomHash[ch-'a']++;
        }

        int magazineHash[] = new int[26];
        for(char ch:magazine.toCharArray()){
            magazineHash[ch-'a']++;
        }

        for(int i=0;i<ransomNote.length();i++){
            char ch = ransomNote.charAt(i);
            if(ransomHash[ch-'a']>magazineHash[ch-'a'])
                return false;
        }
        return true;
    }
}