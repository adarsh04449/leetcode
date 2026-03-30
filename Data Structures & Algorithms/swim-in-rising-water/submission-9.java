class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[2]-b[2]));
        pq.add(new int[]{0,0,grid[0][0]});

        boolean[][] vis = new boolean[grid.length][grid[0].length];

        int maxElevation = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int h = curr[2];
            if(vis[r][c]){
                continue;
            }

            vis[r][c] = true;
            maxElevation = Math.max(maxElevation, h);

            if(r == grid.length-1 && c == grid[0].length-1){
                break;
            }

            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length){
                    continue;
                }

                pq.add(new int[]{nr, nc, grid[nr][nc]});
            }
        }

        return maxElevation;
    }
}
