class Solution {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        int k = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                idx++;
                k++;
            }
        }
        return k;
    }
}