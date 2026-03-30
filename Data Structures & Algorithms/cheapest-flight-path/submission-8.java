class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] flight : flights){
            int u = flight[0];
            int v = flight[1];
            int p = flight[2];

            graph[u].add(new int[]{v, p});
        }

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));

        pq.add(new int[]{src,0,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            int currP = curr[1];
            int stops = curr[2];

            if(stops > k+1){
                continue;
            }

            if(u == dst){
                return currP;
            }

            for(int[] neigh : graph[u]){
                int v = neigh[0];
                int p = neigh[1];

                pq.add(new int[]{v, currP+p, stops+1});
            }
        }

        return -1;

    }
}
