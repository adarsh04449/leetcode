class KthLargest {

    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }

        int size = pq.size();

        while(size > k){
            pq.poll();
            size--;
        }
        
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > k){
            pq.remove();
        }

        return pq.peek();
    }
}
