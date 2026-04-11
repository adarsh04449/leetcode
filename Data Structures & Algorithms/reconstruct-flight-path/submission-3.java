class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> ticket : tickets){
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }

        Stack<String> s = new Stack<>();
        s.add("JFK");
        List<String> res = new ArrayList<>();

        while(!s.isEmpty()){
            String src = s.peek();
            PriorityQueue<String> pq = map.get(src);
            if(pq != null && !pq.isEmpty()){
                s.push(pq.poll());
            }else{
                res.add(s.pop());
            }
        }

        Collections.reverse(res);
        return res;
    }
}
