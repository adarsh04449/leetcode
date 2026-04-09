class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->y[1] - x[1]);
        if(a != 0){
            pq.offer(new int[]{'a', a});
        }
        if(b != 0){
            pq.offer(new int[]{'b', b});
        }
        if(c != 0){
            pq.offer(new int[]{'c', c});
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            int[] first = pq.poll();
            char ch1 = (char) first[0];
            int freq1 = first[1];

            int len = sb.length();

            if(len >= 2 && sb.charAt(len-1) == ch1 && sb.charAt(len-2) == ch1){
                if(pq.isEmpty()){
                    break;
                }
                int[] second = pq.poll();
                char ch2 = (char)second[0];
                int freq2 = second[1];

                sb.append(ch2);
                freq2--;
                if(freq2 > 0){
                    pq.offer(new int[]{ch2, freq2});
                }
                pq.offer(first);
            }else{
                sb.append(ch1);
                freq1--;
                if(freq1 > 0){
                    pq.offer(new int[]{ch1, freq1});
                }
            }
        }

        return sb.toString();
    }
}