class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=-1;
            }
        }
        return find(coins,coins.length,0,amount,dp)==100000000?-1:find(coins,coins.length,0,amount,dp);
    }

    public int find(int coins[],int n,int index,int amount,int dp[][]){

        if(amount==0){
            return 0;
        }
        if(index>=n){
            return (int)(1e8);
        }

        if(dp[index][amount]!=-1) return dp[index][amount];
        int pick=(int)(1e8);
        if(coins[index]<=amount){
            pick=1+find(coins,n,index,amount-coins[index],dp);
        }
        int not=0+find(coins,n,index+1,amount,dp);
        dp[index][amount]=Math.min(pick,not);
        return dp[index][amount];
    }
}