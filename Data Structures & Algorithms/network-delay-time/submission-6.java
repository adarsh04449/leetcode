class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n+1];

        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        int[] timeToReach = new int[n+1];
        Arrays.fill(timeToReach, Integer.MAX_VALUE);
        timeToReach[k] = 0;

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int t = time[2];

            graph[u].add(new int[]{v, t});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1] - b[1]));
        pq.add(new int[]{k, 0});


        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            int t = curr[1];

            if(t > timeToReach[u]){
                continue;
            }
            
            for(int[] neigh : graph[u]){
                int v = neigh[0];
                int time = neigh[1];

                if(t + time < timeToReach[v]){
                    timeToReach[v] = t + time;
                    pq.add(new int[]{v, t + time});
                }
            }
        }

        int totalTime = Integer.MIN_VALUE;
        for(int i = 1; i < n+1; i++){
            if(timeToReach[i] == Integer.MAX_VALUE){
                return -1;
            }else{
                totalTime = Math.max(totalTime, timeToReach[i]);
            }
        }

        return totalTime;
    }
}
