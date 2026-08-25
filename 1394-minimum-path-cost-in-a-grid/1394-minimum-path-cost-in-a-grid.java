class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int n = grid.length , m = grid[0].length;
        int dp[][] = new int[n][m];

        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],(int)1e9);

        for(int i=0;i<m;i++)
            dp[0][i] = grid[0][i];

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++ ){

                for(int k=0;k<m;k++){
                    int su = dp[i-1][k];
                    int mo = moveCost[grid[i-1][k]][j] + grid[i][j] ;
                    dp[i][j] = Math.min(su+mo,dp[i][j]); 
                }

            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            ans = Math.min(ans,dp[n-1][j]);
        }
        return ans;
    }
}