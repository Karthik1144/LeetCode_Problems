class Solution {
    public int numEnclaves(int[][] grid) {
        int n  = grid.length , m = grid[0].length;
        int dRow[] = {0,0,1,-1};
        int dCol[] = {1,-1,0,0};
        int vis[][] = new int[n][m];

        for(int i=0;i<m;i++){
            if(grid[0][i] == 1)
                dfs(0,i,dRow,dCol,grid,vis);

            if(grid[n-1][i] == 1)
                dfs(n-1,i,dRow,dCol,grid,vis);
        }  

        for(int i=0;i<n;i++){
            if(grid[i][0] == 1)
                dfs(i,0,dRow,dCol,grid,vis);

            if(grid[i][m-1] == 1)
                dfs(i,m-1,dRow,dCol,grid,vis);
        }
        int c = 0;
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(vis[i][j] == 0 && grid[i][j] == 1)
                    c++;
            }
        }
        return c;
    }
    public void dfs(int row,int col,int dRow[],int dCol[],int grid[][],int vis[][]){
        int n = grid.length , m = grid[0].length;
        vis[row][col] = 1;

        for(int i=0;i<4;i++){
            int nrow = row + dRow[i];
            int ncol = col + dCol[i];

            if(nrow<0 || nrow >=n || ncol<0 || ncol>=m || grid[nrow][ncol] == 0 ||vis[nrow][ncol] == 1 )
                continue;
            if(grid[nrow][ncol] == 1)
                dfs(nrow,ncol,dRow,dCol,grid,vis);
        }
    }
}