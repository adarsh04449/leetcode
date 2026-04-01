class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < dp.length; i++){
            if(i != cost.length){
                dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
            }else{
                dp[i] = Math.min(dp[i-1], dp[i-2]);
            }
        }

        return dp[cost.length];
    }
}
