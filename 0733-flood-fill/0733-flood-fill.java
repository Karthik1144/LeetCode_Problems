class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image.length==0)
            return image;

        int n = image.length, m = image[0].length;

        if(image[sr][sc]==color)
            return image;

        int originalStart = image[sr][sc];

        Queue<int[]> q = new LinkedList<>();
        image[sr][sc] = color;
        q.offer(new int[]{sr,sc});

        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};

        while(!q.isEmpty()){
            int k = q.size();
            for(int i=0;i<k;i++){
                int pos[] = q.poll();
                int x = pos[0] , y = pos[1];

                for(int d=0;d<4;d++){
                    int nx = x+dx[d], ny = y+dy[d];

                    if(nx<0 || ny<0 || nx>=n || ny>=m || image[nx][ny] != originalStart)
                        continue;

                    image[nx][ny] = color;
                    q.offer(new int[]{nx,ny}); 
                }
            }
        }
        return image;
    }
}