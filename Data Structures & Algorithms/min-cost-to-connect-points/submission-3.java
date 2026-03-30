class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] dist = new int[n];
        boolean[] vis = new boolean[n];

        int edges = 0;
        int node = 0;
        int res = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);

        while(edges < n-1){
            vis[node] = true;
            int nextNode = -1;
            for(int i = 0; i < n; i++){
                if(vis[i]) continue;
                int currDist = Math.abs(points[i][0]-points[node][0]) + Math.abs(points[i][1] - points[node][1]);
                dist[i] = Math.min(currDist, dist[i]);

                if(nextNode == -1 || dist[i] < dist[nextNode]){
                    nextNode = i;
                }
            }

            node = nextNode;
            res += dist[nextNode];
            edges++;
        }
        return res;
    }
}
