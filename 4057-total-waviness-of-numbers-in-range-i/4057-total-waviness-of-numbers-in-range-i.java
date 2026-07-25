class Solution {
    public int totalWaviness(int num1, int num2) {
        int c = 0;
        for(int i=num1;i<=num2;i++)
            c += isSafe(i);
        return c;
    }
    int isSafe(int num){
        if(num<=99)
            return 0;
        int count =0;
        String str = String.valueOf(num);
        for(int i=1;i<str.length()-1;i++){
            if(str.charAt(i-1)<str.charAt(i) && str.charAt(i)>str.charAt(i+1))
                count++;
            if(str.charAt(i-1)>str.charAt(i) && str.charAt(i)<str.charAt(i+1))
                count++;
        }

        return count;
    }
}