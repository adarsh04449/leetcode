class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] m : memo){
            Arrays.fill(m, -1);
        }
        return dfs(0, 0, obstacleGrid, memo);
    }

    public int dfs(int i, int j, int[][] matrix, int[][] memo){
        if(i >= matrix.length || j >= matrix[0].length || matrix[i][j] == 1){
            return 0;
        }

        if(i == matrix.length-1 && j == matrix[0].length-1){
            return 1;
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }


        int right = dfs(i, j+1, matrix, memo);
        int down = dfs(i+1, j, matrix, memo);

        return memo[i][j] = right + down;
    }
}