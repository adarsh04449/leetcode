class Solution {
    public int maxProfit(int[] prices) {
      Integer[][] memo = new Integer[prices.length][2];  
      return dfs(0,1,prices,memo);
    }

    public int dfs(int i, int cooldown, int[] prices, Integer[][] memo){
        if(i >= prices.length){
            return 0;
        }

        if(memo[i][cooldown] != null){
            return memo[i][cooldown];
        }

        if(cooldown == 1){
            int buy = dfs(i+1, 0, prices, memo) - prices[i];
            int skip = dfs(i+1, 1, prices, memo);
            return memo[i][cooldown] = Math.max(buy, skip);
        }else{
            int sell = prices[i] + dfs(i+2, 1, prices, memo);
            int hold = dfs(i+1, 0, prices, memo);
            return memo[i][cooldown] = Math.max(sell, hold);
        }
    }
}
