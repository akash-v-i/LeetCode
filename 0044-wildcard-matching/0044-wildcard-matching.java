class Solution {
    public boolean isMatch(String b, String a) {
        int n=a.length();
        int m=b.length();

        Boolean dp[][]=new Boolean[n][m];
        return find(n-1,m-1,a,b,dp);
    }

    public boolean find(int n,int m,String a,String b,Boolean dp[][]){
        if(n<0 && m<0){
            return true;
        }
        if(n<0){
            return false;
        }
        if(m<0){
            for(int i=0;i<=n;i++){
                if(a.charAt(i)!='*'){
                    return false;
                }
            }
            return true;
        }
        if(dp[n][m]!=null) return dp[n][m];

        if(a.charAt(n)=='?' || a.charAt(n)==b.charAt(m)){
            dp[n][m]=find(n-1,m-1,a,b,dp);
            return dp[n][m];
        }
        else if(a.charAt(n)=='*'){
            dp[n][m]=find(n-1,m,a,b,dp)||find(n,m-1,a,b,dp);
            return dp[n][m];
        }
        return false;
    }


}