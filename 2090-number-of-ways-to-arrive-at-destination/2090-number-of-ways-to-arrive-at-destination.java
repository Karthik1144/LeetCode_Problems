class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int node[]:roads){
            adj.get(node[0]).add(new int[]{node[1],node[2]});
            adj.get(node[1]).add(new int[]{node[0],node[2]});
        }

        long dist[] = new long[n];
        int ways[] = new int[n];
        for(int i=0;i<n;i++)
            dist[i] = Long.MAX_VALUE;

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0,0});

        int mod = (int)1e9+7;
        while(!pq.isEmpty()){
            long current[] = pq.poll();
            long dis = current[0] ;
            int  node = (int)current[1];

            for(int it[] : adj.get(node)){
                int nextNode = it[0]  ;
                long cost = dis + it[1];

                if(cost < dist[nextNode]){
                    dist[nextNode] = cost;
                    pq.offer(new long[]{cost,nextNode});
                    ways[nextNode] = ways[node];
                }
                else if(cost == dist[nextNode])
                    ways[nextNode] = (ways[nextNode] + ways[node]) % mod;
            }
        }
        return (int)ways[n-1];
    }
}