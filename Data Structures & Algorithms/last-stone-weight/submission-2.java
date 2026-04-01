class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int stone : stones){
            pq.offer(stone);
        }

        while(pq.size() > 1){
            int stone1 = pq.poll();
            int stone2 = pq.poll();

            if(stone1 == stone2){
                continue;
            }else if(stone1 < stone2){
                pq.add(stone2 - stone1);
            }else{
                pq.add(stone1 - stone2);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();

    }
}
