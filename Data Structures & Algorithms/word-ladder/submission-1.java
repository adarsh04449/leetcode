class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord) || beginWord.equals(endWord)){
            return 0;
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < wordList.size(); i++){
            String s = wordList.get(i);
            for(int j = 0; j < s.length(); j++){
                String key = s.substring(0,j) + '*' + s.substring(j+1);
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(s);
            }
        }

        Set<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int res = 0;
        vis.add(beginWord);
        q.add(beginWord);

        while(!q.isEmpty()){
            res++;
            int size = q.size();

            for(int i = 0; i < size; i++){
                String curr = q.poll();

                if(curr.equals(endWord)){
                    return res;
                }

                for(int j = 0; j < curr.length(); j++){
                    String key = curr.substring(0, j) + '*' + curr.substring(j+1);

                    if(map.containsKey(key)){
                        for(String s : map.get(key)){
                            if(!vis.contains(s)){
                                vis.add(s);
                                q.add(s);
                            }
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}
