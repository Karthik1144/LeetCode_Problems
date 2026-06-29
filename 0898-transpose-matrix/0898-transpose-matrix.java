class Solution {
    public int[][] transpose(int[][] nums) {
        int n = nums.length , m = nums[0].length;
        int ans[][] = new int[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[j][i] = nums[i][j]; 
            }
        }
        return ans;
    }
}