class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return dfs(0, s, wordDict, memo);
    }

    public boolean dfs(int start, String s, List<String> wordDict, Boolean[] memo){
        if(start == s.length()){
            return true;
        }

        if(memo[start] != null){
            return memo[start];
        }

        for(String word : wordDict){
            int len = word.length();
            if(start + len <= s.length() && s.substring(start, start+len).equals(word)){
                if(dfs(start+len, s, wordDict, memo)){
                    return memo[start] = true;
                }
            }
        }

        return memo[start] = false;
    }
}
