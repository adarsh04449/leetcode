class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b)->(a[0]-b[0]));
        int currStart = intervals[0][0];
        int currEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= currEnd){
                currEnd = Math.max(currEnd, intervals[i][1]);
            }else{
                res.add(new int[]{currStart, currEnd});
                currStart = intervals[i][0];
                currEnd = intervals[i][1];
            }
        }

        res.add(new int[]{currStart, currEnd});

        return res.toArray(new int[res.size()][]);
    }
}
