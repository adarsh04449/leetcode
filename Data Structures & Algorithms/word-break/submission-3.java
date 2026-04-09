class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()+1];
        HashSet<String> dict = new HashSet<>(wordDict);
        return dfs(0,s,dict,memo);
    }

    public boolean dfs(int i, String s, HashSet<String> dict, Boolean[] memo){
        if(i == s.length()){
            return true;
        }

        if(memo[i] != null){
            return memo[i];
        }

        for(int j = i; j < s.length(); j++){
            String curr = s.substring(i, j+1);
            if(dict.contains(curr) && dfs(j+1, s, dict, memo)){
                return memo[i] = true;
            }
        }

        return memo[i] = false;
    }
}
