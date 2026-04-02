class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }

        int[][] memo = new int[nums.length][(sum * 2) + 1];

        for(int i = 0; i < memo.length; i++){
            Arrays.fill(memo[i], -1);
        }

        return dfs(0,0,nums,target,sum,memo);
    }

    public int dfs(int i, int currSum, int[] nums, int target, int offSet, int[][] memo){
        if(i == nums.length){
            return currSum == target ? 1 : 0;
        }

        if(memo[i][currSum + offSet] != -1){
            return memo[i][currSum + offSet];
        }

        int add = dfs(i+1, currSum + nums[i], nums, target, offSet, memo);
        int subtract = dfs(i+1, currSum - nums[i], nums, target, offSet, memo);

        return memo[i][currSum + offSet] = add + subtract;
    }
}
