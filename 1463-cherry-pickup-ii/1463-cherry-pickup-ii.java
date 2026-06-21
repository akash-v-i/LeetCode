class Solution {
    public int cherryPickup(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int dp[][][]=new int[n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<m;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return find(arr,0,0,m-1,n,m,dp);
    }
    public int find(int arr[][],int row,int col1,int col2,int n,int m,int dp[][][]){

        if(col1<0 || col2<0 || col1>=m || col2>=m) return (int)-1e8;

        if(row==n-1){
            if(col1==col2){
                return arr[row][col1];
            }
            return arr[row][col1]+arr[row][col2];
        }

        if(dp[row][col1][col2]!=-1) return dp[row][col1][col2];
        int max=0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if(col1==col2){
                    max=Math.max(max,arr[row][col1]+find(arr,row+1,col1+i,col2+j,n,m,dp));  
                }
                else{
                    max=Math.max(max,arr[row][col2]+arr[row][col1]+find(arr,row+1,col1+i,col2+j,n,m,dp));
                }
            }
        }
        dp[row][col1][col2]=max;
        return max;
    }
}