class Solution {
    public long sumAndMultiply(int n) {
        if(n == 0)
            return 0;
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        long x = 0 , ans = 0;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='0'){
                sb.deleteCharAt(i);
                i--;
            }else{
                ans = (long) ans+ sb.charAt(i) - '0';
            }
        }
        // System.out.println(sb);
        return Integer.parseInt(sb.toString())*ans;
    }
}