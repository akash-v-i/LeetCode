class Solution {
    public class Pair{
        int a;
        int b;
        Pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    public int orangesRotting(int[][] grid) {
        boolean vis[][]=new boolean[grid.length][grid[0].length];
        Queue<Pair>qe=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    qe.add(new Pair(i,j));
                    vis[i][j]=true;
                }
            }
        }
        
        int co=-1;
        while(!qe.isEmpty()){
            co++;
            int n=qe.size();
            for(int i=0;i<n;i++){
                Pair temp=qe.poll();
                int x=temp.a;
                int y=temp.b;
                if(x-1>=0 && !vis[x-1][y] && grid[x-1][y]==1){
                    vis[x-1][y]=true;
                    qe.add(new Pair(x-1,y));
                }

                if(y-1>=0 && !vis[x][y-1] && grid[x][y-1]==1){
                    vis[x][y-1]=true;
                    qe.add(new Pair(x,y-1));
                }

                if(x+1<grid.length && !vis[x+1][y] && grid[x+1][y]==1){
                    vis[x+1][y]=true;
                    qe.add(new Pair(x+1,y));
                }

                if(y+1<grid[0].length && !vis[x][y+1] && grid[x][y+1]==1){
                    vis[x][y+1]=true;
                    qe.add(new Pair(x,y+1));
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    return -1;
                }
            }
        }
        return co==-1 ? 0 :co;
    }
}

/*

00 01 02
10 11 12
20 21 22

*/