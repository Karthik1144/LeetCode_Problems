class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int visited[][] = new int[n][m];
        int answer[][] = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    visited[i][j] = 1;
                    q.add(new int[]{i,j,0});
                }
            }
        }

        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};

        while(!q.isEmpty()){
            int cell[] = q.poll();
            int ni = cell[0], nj = cell[1], nd = cell[2];

            answer[ni][nj] = nd;
            for(int d=0;d<4;d++){
                int nrow = ni + dx[d];
                int ncol = nj + dy[d];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol] == 0){
                    visited[nrow][ncol] = 1;
                    q.add(new int[]{nrow,ncol,nd+1});
                }
            }
        }

        return answer;
    }
}