class Solution {
    public int minDistance(String a, String b) {
        int n=a.length();
        int m=b.length();

        int dp[][]=new int[n+1][m+1];
        int max=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    max=Math.max(max,dp[i][j]);
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return n-max+m-max;
    }
}
/*
word1 = "leetcode", word2 = "etco"
etco
*/