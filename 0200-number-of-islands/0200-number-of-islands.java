class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length , m = grid[0].length;
        int dRow[] = {0,0,1,-1};
        int dCol[] = {1,-1,0,0};
        int vis[][] = new int[n][m];
        int answer = 0 ;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    answer++;
                    dfs(i,j,dRow,dCol,grid,vis);
                }
            }
        }
        return answer;
    }

    public void dfs(int row,int col,int dRow[],int []dCol,char grid[][],int vis[][]){
        int n = grid.length,m = grid[0].length;
        vis[row][col] = 1;

        for(int i=0;i<4;i++){
            int nrow = row+dRow[i];
            int ncol = col+dCol[i];

            if(nrow<0 || nrow>=n || ncol<0 || ncol>=m || grid[nrow][ncol] == '0' || vis[nrow][ncol] == 1)
                continue;
            if(grid[nrow][ncol] == '1')
                dfs(nrow,ncol,dRow,dCol,grid,vis);
        }
    }
}