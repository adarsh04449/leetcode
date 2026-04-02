class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        Boolean[][] memo = new Boolean[s1.length()+1][s2.length()+1];
        return dfs(0,0,s1,s2,s3,memo);
    }

    public boolean dfs(int i, int j, String s1, String s2, String s3, Boolean[][] memo){
        if(i > s1.length() && j > s2.length()){
            return false;
        }

        if(i == s1.length() && j == s2.length()){
            return true;
        }

        if(memo[i][j] != null){
            return memo[i][j];
        }

        boolean ok = false;

        if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j)){
            ok = ok | dfs(i+1, j, s1, s2, s3, memo);
        }
        if(!ok && j < s2.length() && s2.charAt(j) == s3.charAt(i+j)){
            ok = ok | dfs(i, j+1, s1, s2, s3, memo);
        }

        return memo[i][j] = ok;
    }
}
