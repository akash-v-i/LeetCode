class Solution {
    public int lengthOfLIS(int[] arr) {
        int n=arr.length;

        int dp[][]=new int[n][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return find(arr,0,-1,dp);
    }

    public int find(int arr[],int index,int prev,int dp[][]){
        if(index==arr.length) return 0;

        if(dp[index][prev+1]!=-1) return dp[index][prev+1];
        int take=0;

        if(prev==-1 || arr[prev]<arr[index]){
            take=1+find(arr,index+1,index,dp);
        }
        int not=find(arr,index+1,prev,dp);
        dp[index][prev+1]=Math.max(take,not);
        return dp[index][prev+1];
    }
}