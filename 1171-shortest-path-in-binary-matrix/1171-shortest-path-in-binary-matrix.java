class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        if(n==1)
            return 1;

        int dist[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j] = (int)1e9;
            }   
        }
        dist[0][0] = 1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{dist[0][0],0,0});

        int drow[] = {-1,-1,-1,0,0,1,1,1};
        int dcol[] = {-1,0,1,-1,1,-1,0,1}; 

        while(!q.isEmpty()){
            int arr[] = q.poll();
            int dis = arr[0] , row = arr[1] , col = arr[2];
            for(int i=0;i<8;i++){
                int nrow = row+drow[i] , ncol = col+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol] == 0 && dis+1<dist[nrow][ncol]){
                    if(nrow==n-1 && ncol==n-1)
                        return dis+1;
                    dist[nrow][ncol] = dis+1;
                    q.add(new int[]{dis+1,nrow,ncol});
                }
            }
        }
        return -1;
    }
}