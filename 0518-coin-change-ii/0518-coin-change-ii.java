class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=-1;
            }
        }
        return find(coins,n,0,amount,dp);
    }
    public int find(int coins[],int n,int index,int amount,int dp[][]){

        if(amount==0){
            return 1;
        }
        if(index>=n) return 0;

        if(dp[index][amount]!=-1) return dp[index][amount];
        int pick=0;
        if(coins[index]<=amount){
            pick=find(coins,n,index,amount-coins[index],dp);
        }
        int not=find(coins,n,index+1,amount,dp);
        dp[index][amount]= pick+not;

        return dp[index][amount];
    }
}