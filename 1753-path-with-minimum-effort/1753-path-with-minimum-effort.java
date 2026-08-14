class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length , m = heights[0].length;
        int [][]dist = new int[n][m];
        for(int row[]:dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0,0,0});

        int dRow[] = {0,0,1,-1};
        int dCol[] = {1,-1,0,0}; 

        while(!pq.isEmpty()){
            int node[] = pq.poll();
            int diff = node[0] , row = node[1] , col = node[2];

             if(row == n-1 && col == m-1)
                    return diff;

            for(int i=0;i<4;i++){
                int nRow = dRow[i] + row, nCol = dCol[i] + col;

                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m){
                    int newEffort = Math.max(Math.abs(heights[nRow][nCol] - heights[row][col]),diff); 

                    if(newEffort < dist[nRow][nCol]){
                        dist[nRow][nCol] = newEffort;
                        pq.add(new int[]{newEffort,nRow,nCol});
                    }
                }              
            } 
        }
        return 0;
    }
}