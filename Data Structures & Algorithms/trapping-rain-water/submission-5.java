class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length-1;
        int lMax = height[0];
        int rMax = height[height.length-1];
        int res = 0;

        while(l < r){
            if(lMax < rMax){
                l++;
                lMax = Math.max(height[l], lMax);
                res += lMax - height[l];
            }else{
                r--;
                rMax = Math.max(height[r], rMax);
                res += rMax - height[r];
            }
        }

        return res;

    }
}
