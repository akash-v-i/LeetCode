class Solution {
    public int maxProfit(int[] arr) {
        
        int dp[][][]=new int[arr.length][2][2];

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<2;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return find(arr,0,1,1,dp);
    }
    public int find(int arr[],int index,int buy,int trans,int dp[][][]){
        if(index==arr.length||trans==-1){
            return 0;
        }

        if(dp[index][buy][trans]!=-1){
            return dp[index][buy][trans];
        }

        if(buy==1){
            dp[index][buy][trans]=Math.max(-arr[index]+find(arr,index+1,0,trans,dp),find(arr,index+1,1,trans,dp));
        }
        else{
            dp[index][buy][trans]=Math.max(arr[index]+find(arr,index+1,1,trans-1,dp),find(arr,index+1,0,trans,dp));
        }
        return dp[index][buy][trans];
    }
}