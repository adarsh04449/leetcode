class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for(int i = 0; i < memo.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return dfs(0,0,memo);
    }

    public int dfs(int i, int j, int[][] memo){
        if(i >= memo.length || j >= memo[0].length){
            return 0;
        }

        if(i == memo.length-1 && j == memo[0].length-1){
            return 1;
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        int right = dfs(i, j+1, memo);
        int down = dfs(i+1, j, memo);

        return memo[i][j] = right + down;
    }
}
