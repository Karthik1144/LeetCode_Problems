class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans =  new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        int left[] = new int[n];
        int lowerDiag[] = new int[2*n-1];
        int upperDiag[] = new int[2*n-1];
        
        solve(0,n,board,left,lowerDiag,upperDiag,ans);
        
        return ans;
    }
    public void solve(int col,int n,char[][] board,int left[],
        int lowerDiag[],int upperDiag[],List<List<String>> ans){

        if(col==n){
            ArrayList<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int row=0;row<n;row++){
            if(left[row]==0 && lowerDiag[row+col]==0 &&
                 upperDiag[n-1+col-row]==0){

                    //Place queen
                    board[row][col] = 'Q';
                    left[row] = 1;
                    lowerDiag[row+col] = 1;
                    upperDiag[n-1+col-row] = 1;

                    solve(col+1,n,board,left,lowerDiag,upperDiag,ans);
                    
                    //remove the Queen
                    board[row][col] = '.';
                    left[row] = 0;
                    lowerDiag[row+col] = 0;
                    upperDiag[n-1+col-row] = 0;

            }
        }
    }
}