class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int max=0;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    int ans=dfs(grid,i,j,vis);
                    max=Math.max(max,ans);
                }
            }
        }
        return max;
    }

    public int dfs(int grid[][],int row,int col,boolean vis[][]){
        if(row>=grid.length || row<0 || col>=grid[0].length || col<0 || grid[row][col]==0 || vis[row][col]){
            return 0;
        }
        vis[row][col]=true;
        return 1+dfs(grid,row-1,col,vis)+dfs(grid,row+1,col,vis)+dfs(grid,row,col-1,vis)+dfs(grid,row,col+1,vis);
    }
}
/*
00 01 02
10 11 12
20 21 22
*/