class Solution {
    public int maxProfit(int k, int[] arr) {
        int n=arr.length;
        int dp[][][]=new int[n][2][k];

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <2 ; j++) {
                for (int l = 0; l <k ; l++) {
                    dp[i][j][l]=-1;
                }
            }
        }
        return find(arr,0,1,k-1,dp);
    }


    public int find(int arr[],int index,int buy,int k,int dp[][][]){
        if (index==arr.length || k<0){
            return 0;
        }

        if (dp[index][buy][k]!=-1) return dp[index][buy][k];
        if (buy==1){
            dp[index][buy][k]=Math.max(-arr[index]+find(arr,index+1,0,k,dp),find(arr,index+1,1,k,dp));
        }
        else {
            dp[index][buy][k]=Math.max(arr[index]+find(arr,index+1,1,k-1,dp),find(arr,index+1,buy,k,dp));
        }
        return dp[index][buy][k];
    }
}

