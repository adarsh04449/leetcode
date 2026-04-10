class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        List<int[]> res = new ArrayList<>();
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }

        while(i < intervals.length && newInterval[1] >= intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        res.add(new int[]{newInterval[0], newInterval[1]});

        while(i < intervals.length){
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);



    }
}
