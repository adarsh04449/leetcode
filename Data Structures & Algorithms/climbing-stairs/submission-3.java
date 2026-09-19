class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return dfs(0, n, memo);
    }

    public int dfs(int i, int n, int[] memo){
        if(i > n){
            return 0;
        }

        if(i == n){
            return 1;
        }

        if(memo[i] != -1){
            return memo[i];
        }

        return memo[i] = dfs(i+1, n, memo) + dfs(i+2, n, memo);
    }
}
