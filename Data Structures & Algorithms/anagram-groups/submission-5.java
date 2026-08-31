class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String s : strs){
            int[] count = new int[26];
            for(int i = 0; i < s.length(); i++){
                count[s.charAt(i)-'a']++;
            }
            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
