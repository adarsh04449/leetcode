class Solution {
    public int countSubstrings(String s) {
        int res = 0;

        for(int i = 0; i < s.length(); i++){
            int odd = checkPalindrome(i, i, s);
            int even = checkPalindrome(i, i+1, s);

            res += odd + even;
        }

        return res;
    }

    public int checkPalindrome(int l, int r, String s){
        int res = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            res++;
            l--;
            r++;
        }

        return res;
    }
}
