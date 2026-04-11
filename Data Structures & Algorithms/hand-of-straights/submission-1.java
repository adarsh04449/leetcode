class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int key : hand){
            map.put(key, map.getOrDefault(key, 0)+1);
        }


        Arrays.sort(hand);

        for(int i = 0; i < hand.length; i++){
            if(map.get(hand[i]) == 0){
                continue;
            }

            for(int j = 0; j < groupSize; j++){
                if(!map.containsKey(hand[i]+j) || map.get(hand[i]+j) == 0){
                    return false;
                }

                map.put(hand[i]+j, map.get(hand[i]+j)-1);
            }
        }

        return true;
    }
}
