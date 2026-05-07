class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            int j = 0;
            String s = strs[i];
            while( j < Math.min(s.length(), prefix.length())){
                if(s.charAt(j) != prefix.charAt(j)){
                    break;
                }
                j++;
            }
            prefix = prefix.substring(0, j);
        }

        return prefix;
    }
}