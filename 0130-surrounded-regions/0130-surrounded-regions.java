class Solution {
    public void solve(char[][] mat) {
        int n = mat.length , m = mat[0].length;
        int []dRow = {0,0,1,-1};
        int []dCol = {1,-1,0,0};
        int [][]vis = new int[n][m];

        //check the if the boundary is "O" for  top and bottom rows at the same time
        for(int i=0;i<m;i++){
            if(mat[0][i] == 'O')
                dfs(0,i,dRow,dCol,mat,vis);

            if(mat[n-1][i] == 'O')
                dfs(n-1,i,dRow,dCol,mat,vis);
        }

        //check the if the boundary is "O" for  left and right cols at the same time
        for(int i=0;i<n;i++){
            if(mat[i][0] == 'O')
                dfs(i,0,dRow,dCol,mat,vis);

            if(mat[i][m-1] == 'O')
                dfs(i,m-1,dRow,dCol,mat,vis);
        }
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(mat[i][j] == 'O' && vis[i][j] == 0)
                    mat[i][j] = 'X';
            }
        }
    }
    public void dfs(int row,int col,int []dRow,int []dCol,char mat[][], int vis[][] ){
        int n = mat.length, m = mat[0].length;
        vis[row][col] = 1;

        for(int i=0;i<4;i++){
            int nrow = row + dRow[i];
            int ncol = col + dCol[i];

            if(nrow<0 ||nrow>=n || ncol<0 || ncol>=m || mat[nrow][ncol] == 'X' || vis[nrow][ncol]==1)
                continue;
            if(mat[nrow][ncol]=='O')
            dfs(nrow,ncol,dRow,dCol,mat,vis);
        } 
    }
}