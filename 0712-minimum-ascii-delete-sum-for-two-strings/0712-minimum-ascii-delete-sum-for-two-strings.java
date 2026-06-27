class Solution {
    public int minimumDeleteSum(String a, String b) {
        int n=a.length();
        int m=b.length();
        int x=0;
        int y=0;
        for(char ch:a.toCharArray()){
            x+=(int)(ch);
        }
        for(char ch:b.toCharArray()){
            y+=(int)(ch);
        }
        int dp[][]=new int[n+1][m+1];
        int max=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=(a.charAt(i-1))+dp[i-1][j-1];
                    max=Math.max(max,dp[i][j]);
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return ((x-max)+(y-max));
    }
}