class Solution {
    public int maxProfit(int[] arr) {
        
        int n=arr.length;
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        return find(arr,0,1,dp);

    }
    public int find(int arr[],int index,int buy,int dp[][]){

        if(index>=arr.length){
            return 0;
        }

        if(dp[index][buy]!=-1) return dp[index][buy];

        if(buy==1){
            dp[index][buy]=Math.max(-arr[index]+find(arr,index+1,0,dp),find(arr,index+1,1,dp));
        }
        else{
            dp[index][buy]=Math.max(arr[index]+find(arr,index+2,1,dp),find(arr,index+1,0,dp));
        }
        return dp[index][buy];
    }
}