class Solution {
    public int maxProduct(int num) {
        int a = Integer.MIN_VALUE , b = Integer.MIN_VALUE;
        while(num>0){
            int d = num%10;
            if(d>a){
                b = a;
                a = d;
            }
            else if(d>b){
                b = d;
            }
            num = num/10;
        }
        return  a*b;
    }
}