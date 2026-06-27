class Solution {
    public int minInsertions(String s) {
        StringBuilder st=new StringBuilder(s);
        String rev=st.reverse().toString();
        int a=s.length();
        int dp[][]=new int[a+1][a+1];

        int max=0;
        for(int i=1;i<=a;i++){
            for(int j=1;j<=a;j++){
                if(s.charAt(i-1)==rev.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    max=Math.max(max,dp[i][j]);
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return a-max;
    }
}