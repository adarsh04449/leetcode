class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->Double.compare(a[1],b[1]));

        for(int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];

            double dist = Math.pow(x, 2) + Math.pow(y, 2);
            pq.add(new double[]{(double)(i), dist});
        }

        int[][] ans = new int[k][2];

        for(int i = 0; i < k; i++){
            double[] point = pq.poll();
            int idx = (int)point[0];

            ans[i] = points[idx];
        }

        return ans;


    }
}
