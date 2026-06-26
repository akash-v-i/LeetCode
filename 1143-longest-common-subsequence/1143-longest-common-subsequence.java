class Solution {
    public int longestCommonSubsequence(String a, String b) {
        int n=a.length();
        int m=b.length();
        int dp[][]=new int[n][m];

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j]=-1;
            }
        }
        return find(a,b,n-1,m-1,dp);
    }
    public  int find(String a, String b,int n,int m,int dp[][]){
        if (n<0 || m<0){
            return 0;
        }

        if (dp[n][m]!=-1) return dp[n][m];
        if (a.charAt(n)==b.charAt(m)){
            dp[n][m]= 1+find(a,b,n-1,m-1,dp);
            return dp[n][m];
        }
        dp[n][m]= Math.max(find(a,b,n-1,m,dp),find(a,b,n,m-1,dp));
        return dp[n][m];
    }
}