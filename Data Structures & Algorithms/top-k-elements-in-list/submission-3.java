class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        HashMap<Integer, List<Integer>> bucket = new HashMap<>();
        for(int key: map.keySet()){
            bucket.putIfAbsent(map.get(key), new ArrayList<>());
            bucket.get(map.get(key)).add(key);
        }

        int j = 0;
        int[] res = new int[k];

        for(int i = nums.length; i >= 0; i--){
            if(bucket.containsKey(i)){
                for(int num : bucket.get(i)){
                    if(k > 0){
                        res[j] = num;
                        k--;
                        j++;
                    }else{
                        break;
                    }
                }
            }
        }

        return res;
    }
}
