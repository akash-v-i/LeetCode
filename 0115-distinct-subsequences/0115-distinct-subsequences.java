class Solution {
    public int numDistinct(String a, String b) {
        int n=a.length();
        int m=b.length();
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return find(n-1,m-1,a,b,dp);
    }

    public int find(int index1,int index2, String a,String b,int dp[][]){

        if (index2 < 0) return 1;
        if (index1 < 0) return 0;
        if (dp[index1][index2]!=-1) return dp[index1][index2];
        if (a.charAt(index1)==b.charAt(index2)){
            dp[index1][index2]=find(index1-1,index2-1,a,b,dp)+find(index1-1,index2,a,b,dp);
            return dp[index1][index2];
        }
        else {
            dp[index1][index2]=find(index1-1,index2,a,b,dp);
        }
        return dp[index1][index2];
    }
}