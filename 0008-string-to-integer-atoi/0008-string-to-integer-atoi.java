class Solution {
    public int myAtoi(String s) {
        if(s.length()==0)
            return 0;

        s = s.trim();
        if(s.length()==0)
            return 0;
        int sign = 1, i = 0;
        if(s.charAt(i)=='+' || s.charAt(i)=='-'){
            if(s.charAt(i)=='-')
                sign = -1;
            i++;
        }

        long ans = 0;
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            ans = ans*10 + s.charAt(i)-'0';

            if(sign*ans>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(sign*ans<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }
        return (int)ans*sign;
    }
}