class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minWeightCapacity = 0;
        int maxWeightCapacity = 0;
        for(int weight: weights){
            minWeightCapacity = Math.max(minWeightCapacity, weight);
            maxWeightCapacity += weight; 
        }

        int l = minWeightCapacity;
        int r = maxWeightCapacity;

        while(l < r){
            int mid = l + (r-l)/2;

            int currDays = calculateDays(weights, mid);
            if(currDays <= days){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }

    public int calculateDays(int[] weights, int capacity){
        int days = 1;
        int currLoad = 0;
        for(int i = 0; i < weights.length; i++){
            if(currLoad + weights[i] > capacity){
                days++;
                currLoad = 0;
            }
            currLoad += weights[i];
        }
        return days;
    }
}