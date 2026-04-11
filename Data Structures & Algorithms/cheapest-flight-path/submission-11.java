class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] flight : flights){
            int source = flight[0];
            int dest = flight[1];
            int cost = flight[2];

            graph[source].add(new int[]{dest, cost});
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        q.add(new int[]{src, 0, 0});


        while(!q.isEmpty()){
            int[] curr = q.poll();
            int source = curr[0];
            int currCost = curr[1];
            int stops = curr[2];

            if(stops > k+1){
                continue;
            }

            if(source == dst){
                return currCost;
            }

            for(int i = 0; i < graph[source].size(); i++){
                int dest = graph[source].get(i)[0];
                int cost = graph[source].get(i)[1];

                q.add(new int[]{dest, currCost+cost, stops+1});
            }
        }

        return -1;
    }
}
