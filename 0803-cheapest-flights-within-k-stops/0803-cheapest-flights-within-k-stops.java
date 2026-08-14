class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int flight[]:flights)
            adj.get(flight[0]).add(new int[] {flight[1],flight[2]});

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,src,0});

        int dist[] = new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;

        while(!q.isEmpty()){
            int current[] = q.poll();
            int steps = current[0] , node = current[1] , cost = current[2];

            for(int adjNode[] : adj.get(node)){
                int nextNode = adjNode[0];
                int edW = adjNode[1];

                if(cost+edW<dist[nextNode] && steps<=k){
                    dist[nextNode] = cost+edW;
                    q.offer(new int[]{steps+1,nextNode,cost+edW});
                }
            }  
        }
        if(dist[dst]==(int)1e9)
            return -1;

        return dist[dst];
    }
}