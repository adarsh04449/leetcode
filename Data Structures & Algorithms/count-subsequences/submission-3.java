class Solution {
    public int numDistinct(String s, String t) {
        int[][] memo = new int[s.length()][t.length()];
        for(int i = 0; i < memo.length; i++){
            Arrays.fill(memo[i], -1);
        }

        return dfs(0,0,s,t,memo);
    }

    public int dfs(int i, int j, String s, String t, int[][] memo){
        if(i >= s.length()){
            return j >= t.length() ? 1 : 0;
        }

        if(j >= t.length()){
            return 1;
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        int res = 0;

        if(s.charAt(i) == t.charAt(j)){
            int take = dfs(i+1, j+1, s, t, memo);
            int skip = dfs(i+1, j, s, t, memo);
            res += take + skip;
        }else{
            res += dfs(i+1, j, s, t, memo);
        }
        

        return memo[i][j] = res;
    }
}
