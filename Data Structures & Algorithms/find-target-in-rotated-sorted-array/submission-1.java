class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        while(l < r){
            int mid = l + (r-l)/2;
            if(nums[mid] > nums[r]){
                l = mid + 1;
            }else{
                r = mid;
            }
        }

        if(l == 0){
            return binarySearch(0, nums.length-1, target, nums);
        }

        int search1 = binarySearch(0, l-1, target, nums);
        int search2 = binarySearch(l, nums.length-1, target, nums);

        if(search1 == -1 && search2 == -1){
            return -1;
        }else if(search1 == -1){
            return search2;
        }else{
            return search1;
        }
    }

    public int binarySearch(int l, int r, int target, int[] nums){
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] < target){
                l = mid + 1;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                return mid;
            }
        }

        return -1;
    }
}
