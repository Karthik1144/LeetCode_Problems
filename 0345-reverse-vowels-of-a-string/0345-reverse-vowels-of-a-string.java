class Solution {
    public String reverseVowels(String s) {
        int left = 0 ,  right = s.length()-1;
        String vowels = "aeiouAEIOU"; 
        char[] st = s.toCharArray();
        while(left<right){
            if(vowels.indexOf(st[left])==-1)
                left++;
            else if(vowels.indexOf(st[right])==-1)
                right--;
            else{
                char temp = st[left];
                st[left] = st[right];
                st[right] = temp;
                left ++;
                right--;
            }
        }
        return  new String(st);
    }
}