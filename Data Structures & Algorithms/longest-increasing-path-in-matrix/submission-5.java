class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < memo.length; i++){
            Arrays.fill(memo[i],-1);
        }

        int maxPath = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                maxPath = Math.max(maxPath, dfs(i, j, -1, matrix, memo));
            }
        }
        return maxPath;
    }

    public int dfs(int i, int j, int prev, int[][] matrix, int[][] memo){
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= prev){
            return 0;
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        int down = 1 + dfs(i+1, j, matrix[i][j], matrix, memo);
        int left = 1 + dfs(i, j-1, matrix[i][j], matrix, memo);
        int right = 1 + dfs(i, j+1, matrix[i][j], matrix, memo);
        int up = 1 + dfs(i-1, j, matrix[i][j], matrix, memo);

        return memo[i][j] = Math.max(Math.max(up, down), Math.max(left, right));
        
    }


}

