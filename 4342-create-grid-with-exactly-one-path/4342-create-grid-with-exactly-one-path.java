class Solution {
    public String[] createGrid(int m, int n) {
        char ans[][] = new char[m][n];
        for(char row[]:ans)
            Arrays.fill(row,'#');

        for(int i=0;i<n;i++)
            ans[0][i] = '.';

        for(int i=0;i<m;i++)
            ans[i][n-1] = '.';

        String s[] = new String[m];
        for(int i=0;i<m;i++)
            s[i] = new String(ans[i]);

        return s;
    }
}