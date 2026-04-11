class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.size(); i++){
            String s = strs.get(i);
            sb.append(s.length());
            sb.append('#');
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while(i < str.length()){
            int j = i;

            while(j < str.length() && str.charAt(j) != '#'){
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));
            i = j+1;
            
            res.add(str.substring(i, i + length));

            i = i + length;
        }

        return res;
    }
}
