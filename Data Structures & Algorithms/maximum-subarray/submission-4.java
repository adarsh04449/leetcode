class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int totalNegatives = 0;
        int maxNegative = Integer.MIN_VALUE;
        int maxSum = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                totalNegatives++;
                maxNegative = Math.max(maxNegative, nums[i]);
            }
            currSum += nums[i];
            if(currSum < 0){
                currSum = 0;
            }
            maxSum = Math.max(currSum, maxSum);
        }

        return totalNegatives == nums.length ? maxNegative : maxSum;
    }
}
