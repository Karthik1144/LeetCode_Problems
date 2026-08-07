class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites  ){
            adj.get(pre[0]).add(pre[1]);
        }

        int vis[] = new int[numCourses];
        int path[] = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){
                if(dfs(i,adj,vis,path)==true)
                    return false;
            }
        }
        return true;
    }
    boolean dfs(int node,List<List<Integer>> adj,int vis[],int path[]){
        vis[node] = 1;
        path[node] = 1;
        for(int it:adj.get(node)){
            if(vis[it]!=1){
                if(dfs(it,adj,vis,path))
                    return true;
            }
            else if(path[it]==1)
                return true;
        }
        path[node] = 0;
        return false;
    }
}