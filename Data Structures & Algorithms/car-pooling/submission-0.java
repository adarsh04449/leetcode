class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(int[] trip: trips){
            pq.add(trip);
        }

        int currCount = 0;
        int prevEnd = 0;
        while(!pq.isEmpty()){
            int[] trip = pq.poll();
            int count = trip[0];
            int currStart = trip[1];
            int currEnd = trip[2];

            if(currStart >= prevEnd){
                currCount = 0;
            }else{
                if(currCount + count > capacity){
                    return false;
                }
            }
            prevEnd = currEnd;
            currCount += count;
        }
        return true;
    }
}