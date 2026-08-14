class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<>());

        for(int[]time: times)
            adj.get(time[0]).add(new int[]{time[1],time[2]});

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        q.offer(new int[]{0,k});

        int dist[] = new int[n+1];
        Arrays.fill(dist,(int)1e9);
        dist[k] = 0;

        while(!q.isEmpty()){
            int current[] = q.poll();
            int  node = current[1] , cost = current[0];

            for(int[] adjNode : adj.get(node)){
                int nextNode = adjNode[0];
                int edW = cost + adjNode[1];

                if(edW<dist[nextNode]){
                    dist[nextNode] = edW;
                    q.offer(new int[]{edW,nextNode});
                }
            } 
        }
        int max = Integer.MIN_VALUE;
         for (int i = 1; i <= n; i++) {
            if (dist[i] == (int) 1e9)
                return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}