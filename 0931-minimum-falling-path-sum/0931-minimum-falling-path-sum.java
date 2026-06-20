class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=Integer.MIN_VALUE;
            }
        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int result=find(arr,n,m,0,i,dp);
            dp[0][i]=result;
            min=Math.min(min,result);
        }
        return min;
    }

    public int find(int arr[][],int n,int m,int x,int y,int dp[][]){
        if (x>=n || y>=m || x<0 || y<0){
            return Integer.MAX_VALUE;
        }
        if (x==n-1 && y<m){
            return arr[x][y];
        }

        if(dp[x][y]!=Integer.MIN_VALUE){
            return dp[x][y];
        }

        int a=find(arr,n,m,x+1,y-1,dp);
         a=Math.min(a,find(arr,n,m,x+1,y,dp));
        a=Math.min(a,find(arr,n,m,x+1,y+1,dp));

        dp[x][y]=arr[x][y]+a;
        return arr[x][y]+a;

    }
}