class TimeMap {
    class Node {
        int timestamp;
        String value;

        Node(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String,List<Node>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Node(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Node> nodes = map.get(key);
        int l = 0;
        int r = nodes.size()-1;
        String ans = "";

        while(l <= r){
            int mid = l + (r-l)/2;

            Node node = nodes.get(mid);

            if(node.timestamp == timestamp){
                return node.value;
            }else if(node.timestamp < timestamp){
                ans = node.value;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return ans;

    }
}
