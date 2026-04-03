class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for(int i = 0; i < memo.length; i++){
            Arrays.fill(memo[i], -1);
        }

        return dfs(0,0, word1, word2, memo);
    }

    public int dfs(int i, int j, String word1, String word2, int[][] memo){
        if(j >= word2.length()){
            return word1.length() - i;
        }

        if(i >= word1.length()){
            return word2.length() - j;
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        if(word1.charAt(i) == word2.charAt(j)){
            return memo[i][j] = dfs(i+1, j+1, word1, word2, memo);
        }else{
            int add = dfs(i, j+1, word1, word2, memo);
            int sub = dfs(i+1, j, word1, word2, memo);
            int replace = dfs(i+1, j+1, word1, word2, memo);

            return memo[i][j] =  1 + Math.min(Math.min(add, sub), replace);
        }
    }
}
