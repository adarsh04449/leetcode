class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length][amount+1];

        for(int i = 0; i < memo.length; i++){
            Arrays.fill(memo[i], -1);
        }

        return dfs(0, amount, coins, memo);
    }

    public int dfs(int i, int rem, int[] coins, int[][] memo){
        if(rem == 0){
            return 1;
        }
        if(i >= coins.length || rem < 0){
            return 0;
        }

        if(memo[i][rem] != -1){
            return memo[i][rem];
        }

        int combination1 = dfs(i, rem-coins[i], coins, memo);
        int combination2 = dfs(i+1, rem, coins, memo);

        return memo[i][rem] = combination1 + combination2;
    }
}
