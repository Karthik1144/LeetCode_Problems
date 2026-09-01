class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length , m = grid[0].length , ans = 0;
        int vis[][] = new int[n][m];

        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    bfs(i,j,vis,dx,dy,grid);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void bfs(int row,int col,int vis[][],int dx[],int dy[],char grid[][]){
        if(row<0 || col<0 || row>=grid.length || col >= grid[0].length)
            return;

        vis[row][col] = 1;
        for(int i=0;i<4;i++){
            int nrow = row + dx[i] , ncol = col + dy[i];
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length &&  grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0)
                bfs(nrow,ncol,vis,dx,dy,grid);
        }

        return;
    }
}