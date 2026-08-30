class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount + 1];

        for (int row[] : dp)
            Arrays.fill(row, -1);

        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0)
                dp[0][t] = t / coins[0];
            else
                dp[0][t] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < coins.length; i++) {
            for (int t = 0; t <= amount; t++) {
                int notTake = dp[i - 1][t];

                int take = Integer.MAX_VALUE;
                if (coins[i] <= t) {
                    int result = dp[i][t - coins[i]];
                    if (result != Integer.MAX_VALUE)
                        take = 1 + result;
                }
                dp[i][t] = Math.min(take, notTake);
            }
        }
        return dp[coins.length - 1][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length-1][amount];
    }
}