class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length==0)
            return 0;

        Queue<int[]> q = new LinkedList<>();

        int n = grid.length , m = grid[0].length;
        int total = 0 , count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] != 0)
                    total++;
                
                if(grid[i][j] == 2)
                    q.offer(new int[]{i,j});
            }
        }

        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};

        int days = 0;
        while(!q.isEmpty()){
            int k = q.size();
            count += k;

            for(int i=0;i<k;i++){
                int curr[] = q.poll();
                int row = curr[0] , col = curr[1];

                for(int d=0;d<4;d++){
                    int nrow = row + dx[d] , ncol = col + dy[d];

                    if(nrow<0 || nrow>=n || ncol<0 || ncol>=m || grid[nrow][ncol] != 1)
                        continue;

                    grid[nrow][ncol] = 2;
                    q.offer(new int[]{nrow,ncol});
                }
            }
            if(!q.isEmpty()) days++;
        }
        return total == count ? days : -1;
    }
}