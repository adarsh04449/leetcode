class Solution {
    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    freshOranges++;
                }
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j,0});
                }
            }
        }

        int totalTime = 0;
        int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int t = curr[2];

            totalTime = Math.max(t, totalTime);

            for(int[] dir: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] == 0 || grid[nr][nc] == 2){
                    continue;
                }

                freshOranges--;
                grid[nr][nc] = 2;
                q.add(new int[]{nr, nc, t+1});
            }
        }

        return freshOranges == 0 ? totalTime : -1;
    }
}
