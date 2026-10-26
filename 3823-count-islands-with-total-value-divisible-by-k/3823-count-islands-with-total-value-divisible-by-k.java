class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length , n = grid[0].length;
        int temp[][] = new int[m][n];

        int c = 0;
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0 && temp[i][j] ==0){
                    long sum = dfs(i,j,m,n,dx,dy,temp,grid);
                    System.out.println(sum);
                    if(sum%k==0){
                        c++;
                    }
                }
            }
        }

        return c;
    }

    long dfs(int row,int col,int m,int n,int dx[],int dy[],int temp[][],int grid[][]){
        if(row<0 || row>=m || col<0 || col>=n || grid[row][col] == 0 
            || temp[row][col] == 1)
            return 0L;
        
        temp[row][col] = 1;

        long sum = grid[row][col];

        for(int i=0;i<4;i++){
          int nr = row+dx[i];
          int nc = col+dy[i];

          sum += dfs(nr,nc,m,n,dx,dy,temp,grid);
        }

        return sum;
    }
}