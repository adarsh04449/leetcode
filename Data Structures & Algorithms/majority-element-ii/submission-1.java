class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer candidate1 = null;
        int count1 = 0;

        Integer candidate2 = null;
        int count2 = 0;

        for(int i = 0; i < nums.length; i++){
            if(candidate1 != null && candidate1 == nums[i]){
                count1++;
            }else if(candidate2 != null && candidate2 == nums[i]){
                count2++;
            }else if(count1 == 0){
                candidate1 = nums[i];
                count1++;
            }else if(count2 == 0){
                candidate2 = nums[i];
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int i = 0; i < nums.length; i++){
            if(candidate1 != null && nums[i] == candidate1){
                count1++;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(candidate2 != null && nums[i] == candidate2){
                count2++;
            }
        }

        List<Integer> res = new ArrayList<>();
        if(count1 > Math.floor(nums.length/3)){
            res.add(candidate1);
        }
        if(count2 > Math.floor(nums.length/3)){
            res.add(candidate2);
        }

        return res;
    }
}