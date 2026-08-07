class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());

        for(int[] pre:prerequisites)
            adj.get(pre[1]).add(pre[0]);

        int vis[] = new int[numCourses];
        int path[] = new int[numCourses];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<numCourses;i++){
            if(vis[i]==0)
                if(dfs(i,adj,vis,path,st))
                    return new int[0];
        } 
        int ind = 0;
        int ans[] = new int[numCourses];
        while(!st.isEmpty())
            ans[ind++] = st.pop();

        return ans;
    }
    boolean dfs(int node,List<List<Integer>> adj,int vis[],int path[],Stack<Integer> st){
        vis[node] = 1;
        path[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it]!=1){
                if(dfs(it,adj,vis,path,st))
                    return true;
            }
            else if(path[it]==1)
                return true;
        }
        path[node] = 0;
        st.push(node);
        return false;
    }
}