class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][]=new int[target+1][n+1];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return find(n,k,target,0,0,dp);
    }

    public int find(int n,int k,int target,int sum,int idx, int dp[][]){
        if(idx==n && target==sum){
            return 1;
        }
        if(idx==n || target<sum) return 0;
        if(dp[sum][idx]!=-1) return dp[sum][idx]; 
        int ans=0;

        for(int i=1;i<=k;i++){
            ans=(ans+find(n,k,target,sum+i,idx+1,dp))%(1000000007);
        }
        dp[sum][idx]=ans;
        return ans;
    }
}