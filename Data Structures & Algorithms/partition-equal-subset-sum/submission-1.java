class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length == 1){
            return false;
        }

        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if(sum % 2 != 0){
            return false;
        }

        int reqSum = sum/2;

        Boolean[][] memo = new Boolean[nums.length][reqSum + 1];

        return dfs(nums, 0, reqSum, memo);
    }

    public boolean dfs(int[] nums, int i, int target, Boolean[][] memo){
        if(i == nums.length){
            return target == 0;
        }

        if(target < 0){
            return false;
        }

        if(memo[i][target] != null){
            return memo[i][target];
        }

        boolean take = dfs(nums, i+1, target-nums[i], memo);
        boolean skip = dfs(nums, i+1, target, memo);

        return memo[i][target] = take || skip;
    }
}
