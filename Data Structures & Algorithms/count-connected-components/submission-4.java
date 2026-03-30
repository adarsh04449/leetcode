class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] par = new int[n];
        int[] rank = new int[n];

        for(int i = 0; i < n; i++){
            par[i] = i;
        }

        int connected = n;

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(union(u, v, par, rank)){
                connected--;
            }
        }

        return connected;
    }

    public int find(int x, int[] par){
        if(par[x] != x){
            par[x] = find(par[x], par);
        }

        return par[x];
    }

    public boolean union(int x, int y, int[] par, int[] rank){
        int parX = find(x, par);
        int parY = find(y, par);

        if(parX == parY){
            return false;
        }

        if(rank[parX] < rank[parY]){
            par[parX] = parY;
        }else if(rank[parX] > rank[parY]){
            par[parY] = parX;
        }else{
            par[parX] = parY;
            rank[parY]++;
        }

        return true;
    }
}
