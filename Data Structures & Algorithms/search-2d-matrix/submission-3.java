class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0;
        int r = (n * m) - 1;

        while(l <= r){
            int mid = l + (r-l)/2;
            int nr = mid / m;
            int nc = mid % m;

            if(matrix[nr][nc] < target){
                l = mid + 1;
            }else if(matrix[nr][nc] > target){
                r = mid - 1;
            }else{
                return true;
            }
        }

        return false;

    }
}
