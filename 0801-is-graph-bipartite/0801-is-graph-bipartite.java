class Solution {
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }

        int vis[] = new int[graph.length];
        Arrays.fill(vis,-1);
        for(int i=0;i<vis.length;i++){
            if(vis[i] == -1)
                if(dfs(i,0,vis,adj)==false)
                    return false;
        }
        return true;
    }
    public boolean dfs(int i,int col,int vis[],List<List<Integer>> adj){
        vis[i] = col;
        for(int it:adj.get(i)){
            if(vis[it] == -1){
                if(dfs(it,1-col,vis,adj)==false)
                    return false;
            }
            else if(vis[it]==col)
                return false;
        }
        return true;
    }
}