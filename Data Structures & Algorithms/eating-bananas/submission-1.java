class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int i = 0; i < piles.length; i++){
            right = Math.max(piles[i], right);
        }
        int res = right;

        while(left <= right){
            int mid = left + (right-left)/2;
            int currHours = 0;
            for(int pile : piles){
                currHours += (int) Math.ceil((double)pile / mid);
            }

            if(currHours > h){
                left = mid+1;
            }else{
                res = mid;
                right = mid - 1;
            }
        }

        return res;
    }
}
