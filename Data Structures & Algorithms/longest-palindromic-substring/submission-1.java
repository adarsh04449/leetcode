class Solution {
    public String longestPalindrome(String s) {
        int left = 0;
        int right = 0;

        for(int i = 0; i < s.length(); i++){
            int[] odd = checkPalindrome(i, i, s);
            int[] even = checkPalindrome(i, i+1, s);

            if(odd[1] - odd[0] > right - left){
                right = odd[1];
                left = odd[0];
            }

            if(even[1] - even[0] > right - left){
                right = even[1];
                left = even[0];
            }
        }

        return s.substring(left, right+1);


    }

    public int[] checkPalindrome(int left, int right, String s){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return new int[]{left+1, right-1};
    }
}
