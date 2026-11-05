class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Integer.compare(b.dis,a.dis));
        for(int point[]:points){
            int dis = (int) point[0] * point[0]
                              + (int) point[1] * point[1];

            pq.offer(new Pair(dis,point));
            if(pq.size()>k)
                pq.poll();
        }
        int ans[][] = new int[k][2];
        int i=0;
        for(Pair p:pq){
            ans[i++] = p.node;
        }
        return ans;
    }
    class Pair{
        int dis;
        int[] node;
        Pair(int dis,int[] node){
            this.dis = dis;
            this.node = node;
        } 
    }
}