class Solution {
    public boolean isMatch(String b, String a) {
        
        int n=a.length();
        int m=b.length();

        Boolean dp[][]=new Boolean[n][m];

        return find(n-1,m-1,a,b,dp);
    }

    public boolean find(int i1,int i2,String a,String b,Boolean dp[][]){
        if(i1<0 && i2<0){
            return true;
        }

        if(i1<0){
            return false;
        }

        if (i2 < 0) {
            for (int i = 0; i <= i1; i++) {
                if (a.charAt(i) != '*')
                    return false;
            }
            return true;
        }
        if(dp[i1][i2]!=null) return dp[i1][i2];


        if (a.charAt(i1) == b.charAt(i2) || a.charAt(i1) == '?') {
            dp[i1][i2]= find(i1 - 1, i2 - 1, a, b,dp);
            return dp[i1][i2];
        } else if (a.charAt(i1) == '*') {
            dp[i1][i2]= find(i1, i2 - 1, a, b,dp) || find(i1 - 1, i2, a, b,dp);
            return dp[i1][i2];
        }
        return false;
    }
}