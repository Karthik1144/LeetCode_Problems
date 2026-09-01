class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length , n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int totOranges = 0 , rotten = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 || grid[i][j] == 2)
                    totOranges++;

                if(grid[i][j] == 2 ){
                    rotten++;
                    q.offer(new int[]{i,j});
                }
            }
        }

        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};

        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                int row = curr[0] , col = curr[1];

                for(int d=0;d<4;d++){
                    int nrow = row+dx[d] ,ncol = col + dy[d];

                    if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol] ==1){
                        grid[nrow][ncol] = 2;
                        rotten++;
                        q.offer(new int[]{nrow,ncol});
                    }
                }
            } 
            time++;
        }

        return totOranges == (rotten) ? time-1 :  -1;
    }
}