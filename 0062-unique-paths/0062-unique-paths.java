class Solution {
    int dp[][];
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];

        dp[0][0]=find(0,1,m,n)+find(1,0,m,n);
        dp[m-1][n-1]=1;
        return dp[0][0];
    }

    public int find(int x,int y,int n,int m){
        if(x>=n || y>=m || x<0 || y<0) return 0;

        if(x==n-1 && y==m-1) return 1;
        if(dp[x][y]!=0) return dp[x][y];

        dp[x][y]=find(x+1,y,n,m)+find(x,y+1,n,m);
        return dp[x][y];
    }
}
/*
00 01 02
10 11 12
20 21 22
*/