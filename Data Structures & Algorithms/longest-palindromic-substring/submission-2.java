class Solution {
    public String longestPalindrome(String s) {
        int bestL = 0;
        int bestR = 0;

        for(int i = 0; i < s.length(); i++){
            int[] odd = helper(i, i, s);
            int[] even = helper(i, i+1, s);

            if(odd[1] - odd[0] >= bestR - bestL){
                bestL = odd[0];
                bestR = odd[1];
            }

            if(even[1] - even[0] >= bestR - bestL){
                bestL = even[0];
                bestR = even[1];
            }
        }

        return s.substring(bestL, bestR+1);
    }

    public int[] helper(int i, int j, String s){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }

        return new int[]{i+1, j-1};
    }
}
