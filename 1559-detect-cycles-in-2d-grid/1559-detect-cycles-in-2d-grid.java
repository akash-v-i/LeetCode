class Solution {
    int[] diff = {0,1,0,-1,0};
    int m,n;
    public boolean containsCycle(char[][] grid) {
         m = grid.length;
         n = grid[0].length;
        
        boolean[][] vis = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!vis[i][j]) {
                    if(bfs(grid, vis, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }
    private boolean bfs(char[][] grid, boolean[][] vis, int i, int j){
        Queue<Pair>qe=new LinkedList<>();
        qe.add(new Pair(i,j,-1,-1));

        while(!qe.isEmpty()){
            Pair temp=qe.poll();
            int r=temp.x;
            int c=temp.y;
            vis[r][c]=true;
            int pr=temp.px;
            int pc=temp.py;

            for(int k=0;k<4;k++){
                int nr=r+diff[k];
                int nc=c+diff[k+1];

                if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length)
                    continue;
                    
                if(grid[nr][nc] != grid[r][c])
                    continue;

                if(!vis[nr][nc]) {
                    qe.offer(new Pair(nr, nc, r, c));
                }
                else if(nr != pr || nc != pc) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Pair{
    int x,y,px,py;

    Pair(int x,int y,int px,int py){
        this.x=x;
        this.y=y;
        this.px=px;
        this.py=py;
    }
}