class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size(), m = triangle.get(triangle.size()-1).size();
        int dp[][] = new int[n][m];

        for(int row[]:dp)
            Arrays.fill(row,(int)1e9);

        dp[0][0] = triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<triangle.get(i).size();j++){


                int top = dp[i-1][j]+triangle.get(i).get(j);

                int topLeft = (dp[i-1][j-1] == Integer.MAX_VALUE) ? 
                                        Integer.MIN_VALUE : dp[i-1][j-1] + triangle.get(i).get(j);

                dp[i][j] = Math.min(top,topLeft);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<m;i++)
            min = Math.min(dp[n-1][i],min);

        return min;
    }
}