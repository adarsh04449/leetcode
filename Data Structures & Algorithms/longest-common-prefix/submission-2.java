class Solution {
    public String longestCommonPrefix(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            String s = strs[i];
            for(int j = 0; j <= s.length(); j++){
                String key = s.substring(0,j);
                if(!map.containsKey(key)){
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(s);
            }
        }

        String ans = "";
        int maxLen = 0;

        for(String s : map.keySet()){
            if(map.get(s).size() == strs.length){
                if(s.length() > maxLen){
                    maxLen = s.length();
                    ans = s;
                }
            }
        }

        return ans;

    }
}