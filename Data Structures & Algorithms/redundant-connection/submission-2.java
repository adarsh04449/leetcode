class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        int[] par = new int[n+1];
        int[] rank = new int[n+1];

        for(int i = 1; i < par.length; i++){
            par[i] = i;
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(!union(u, v, par, rank)){
                return new int[]{u, v};
            }
        }

        return new int[0];
    }

    public int find(int i, int[] par){
        if(par[i] != i){
            par[i] = find(par[i], par);
        }
        return par[i];
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
