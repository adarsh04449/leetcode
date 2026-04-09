class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b)->a[1]-b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        int currPass = 0;

        for(int[] trip : trips){
            int count = trip[0];
            int start = trip[1];
            int end = trip[2];

            while(!pq.isEmpty() && pq.peek()[0] <= start){
                currPass -= pq.poll()[1];
            }

            currPass += count;
            if(currPass > capacity){
                return false;
            }

            pq.offer(new int[]{end, count});
        }
        return true;
    }
}