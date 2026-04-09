class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int currMax = 1;
        int currMin = 1;

        for(int i = 0; i < nums.length; i++){
            int temp = currMax * nums[i];
            currMax = Math.max(Math.max(temp, currMin * nums[i]), nums[i]);
            currMin = Math.min(Math.min(temp, currMin * nums[i]), nums[i]);

            res = Math.max(currMax, res);
        }
        return res;
    }
}
