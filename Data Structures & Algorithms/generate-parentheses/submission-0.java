class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        backtrack(0,0,n,new StringBuilder(),res);
        return res;
    }

    public void backtrack(int open, int close, int n, StringBuilder s, List<String> res){
        if(s.length() == 2 * n){
            res.add(s.toString());
            return;
        }

        if(open < n){
            backtrack(open + 1, close, n, s.append('('), res);
            s.deleteCharAt(s.length() - 1);
        }

        if(close < open){
            backtrack(open, close+1, n, s.append(')'), res);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
