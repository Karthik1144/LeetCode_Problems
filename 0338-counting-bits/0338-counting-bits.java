class Solution {
    public int[] countBits(int n) {
        int ans[] = new int[n+1];
        for(int i=0;i<=n;i++)
            ans[i] = countSetBits(i);

        return ans;
    }
    public int countSetBits(int num){
        int c = 0;
        while(num>0){
            if((num & 1) == 1)
                c++;
            num = num >> 1;
        }
        return c;
    }
}