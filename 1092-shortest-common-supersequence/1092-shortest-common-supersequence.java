class Solution {
    public String shortestCommonSupersequence(String a, String b) {
        int n=a.length();
        int m=b.length();

        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return find(dp,n,m,a,b);
    }

    public String find(int dp[][],int x,int y,String a, String b){
        if(x==0 || y==0){
            if(x==0){
                return b.substring(0,y);
            }
            return a.substring(0,x);
            
        }

        if(a.charAt(x-1)==b.charAt(y-1)){
            return find(dp,x-1,y-1,a,b)+a.charAt(x-1);
        }
        else if(dp[x-1][y]>=dp[x][y-1]){
            return find(dp,x-1,y,a,b)+a.charAt(x-1);
        }
        else{
            return find(dp,x,y-1,a,b)+b.charAt(y-1);
        }
    }
}