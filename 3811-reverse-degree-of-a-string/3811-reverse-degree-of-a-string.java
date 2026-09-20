class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for(int i=0;i<s.length();i++){
            int indRev = 'z'-s.charAt(i)+1;
            sum += (indRev*(i+1));
        }
        return sum;
    }
}