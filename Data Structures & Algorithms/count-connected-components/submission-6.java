class Solution {
    public int find(int x, int[] par){
        if(x != par[x]){
            par[x] = find(par[x], par);
        }

        return par[x];
    }

    public void union(int x, int y, int[] par, int[] rank){
        int parX = find(x, par);
        int parY = find(y, par);

        if(rank[parX] < rank[parY]){
            par[parX] = parY;
        }else if(rank[parX] > rank[parY]){
            par[parY] = parX;
        }else{
            par[parX] = parY;
            rank[parY]++;
        }
    }


    public int countComponents(int n, int[][] edges) {
        int[] par = new int[n];
        int[] rank = new int[n];

        for(int i = 0; i < n; i++){
            par[i] = i;
        }

        for(int[] edge : edges){
            union(edge[0], edge[1], par, rank);
        }

        for(int i = 0; i < n; i++){
            find(i, par);
        }


        HashSet<Integer> components = new HashSet<>();
        for(int i = 0; i < par.length; i++){
            components.add(par[i]);
        }

        return components.size();
    }
}
