class Solution {
    public String reverseOnlyLetters(String s) {
        int i = 0 ,j = s.length()-1;
        char[] sChar = s.toCharArray();
        while(i<j){
            while(!Character.isLetter(sChar[i]) && i<j)
                i++;

            while(!Character.isLetter(sChar[j]) && i<j)
                j--;
                
            if(i==j)
                break;

            char temp = sChar[i];
            sChar[i] = sChar[j];
            sChar[j] = temp;

            i++;j--;
        }
        return new String(sChar);
    }
}