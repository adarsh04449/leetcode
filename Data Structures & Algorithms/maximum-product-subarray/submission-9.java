class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int currMax = 1;
        int currMin = 1;

        for(int num: nums){
            int temp = num * currMax;
            currMax = Math.max(Math.max(temp, currMin * num), num);
            currMin = Math.min(Math.min(temp, currMin * num), num);

            res = Math.max(currMax, res);
        }

        return res;
    }
}
