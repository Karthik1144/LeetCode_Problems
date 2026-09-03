class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        boolean vis[] = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        
        pq.offer(new int[]{0,0});

        int mstAns = 0; 

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int wt = curr[0] , node = curr[1];

            if(!vis[node]){

                vis[node] = true;
                mstAns += wt;

                for(int i=0;i<n;i++){
                    if(!vis[i]){
                        int edgWt = manhattan(points,node,i);
                        pq.offer(new int[]{edgWt,i});
                    }
                }
            }
        }
        return mstAns;
    }
    public int manhattan(int[][] points,int p1,int p2){
        return  Math.abs(points[p1][0] - points[p2][0]) +
                         Math.abs(points[p1][1] - points[p2][1]);
    }
}