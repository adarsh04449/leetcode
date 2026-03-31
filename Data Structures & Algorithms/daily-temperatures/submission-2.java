class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[temperatures.length];

        
        for(int i = temperatures.length-1; i >= 0; i--){
            int currTemp = temperatures[i];
            if(s.isEmpty()){
                s.push(i);
                ans[i] = 0;
            }else{
                if(currTemp < temperatures[s.peek()]){
                    ans[i] = s.peek()-i;
                    s.push(i);
                }else{
                    while(!s.isEmpty() && currTemp >= temperatures[s.peek()]){
                        s.pop();
                    }

                    if(s.isEmpty()){
                        ans[i] = 0;
                    }else{
                        ans[i] = s.peek() - i;
                    }
                    s.push(i);
                }

            }
        }

        return ans;
    }
}
