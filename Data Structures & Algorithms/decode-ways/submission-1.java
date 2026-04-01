class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(0, s, memo);
    }

    public int dfs(int i, String s, int[] memo){
        if(i == s.length()){
            return 1;
        }

        if(s.charAt(i) == '0'){
            return 0;
        }

        if(memo[i] != -1){
            return memo[i];
        }

        int ways = dfs(i+1, s, memo);
        if(i + 1 < s.length()){
            int num = (s.charAt(i) - '0') * 10 + (s.charAt(i+1) - '0');
            if(num >= 10 && num <= 26){
                ways += dfs(i+2, s, memo);
            }
        }

        return memo[i] = ways;
    }
}
