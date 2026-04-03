class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length()+1][p.length()+1];
        return dfs(0,0,s,p,memo);
    }

    public boolean dfs(int i, int j, String s, String p, Boolean[][] memo){
        if(j == p.length()){
            return i == s.length();
        }


        if(memo[i][j] != null){
            return memo[i][j];
        }

        boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');


        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            boolean take = firstMatch && dfs(i+1, j, s, p, memo);
            boolean skip = dfs(i, j+2, s, p, memo);
            return memo[i][j] = take || skip;
        }else{
            return memo[i][j] = firstMatch && dfs(i+1, j+1, s, p, memo);
        }
    }
}
