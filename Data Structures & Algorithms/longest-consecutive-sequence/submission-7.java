class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        int maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i] - 1)){
                int currLen = 0;
                int curr = nums[i];
                while(set.contains(curr)){
                    currLen++;
                    curr = curr + 1;
                }
                maxLen = Math.max(currLen, maxLen);
            }
        }

        return maxLen;
    }
}
