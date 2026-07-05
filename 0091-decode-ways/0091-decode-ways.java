class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;

        int dp[]=new int[s.length()];
        Arrays.fill(dp,-1);
        return find(s, 0,dp);
    }

    public int find(String str, int index,int dp[]) {
        if(index==str.length()) return 1;

        if(str.charAt(index)=='0') return 0;

        if(dp[index]!=-1) return dp[index];

        dp[index]=find(str,index+1,dp);

        if(index+1<str.length()){
            int a=str.charAt(index)-'0';
            int b=str.charAt(index+1)-'0';
            int sum=(a*10)+b;
            if(sum>=1 && sum<=26){
                dp[index]+=find(str,index+2,dp);
            }
        }

        return dp[index];
        
    }
}

/*

         226
        2 22 26

*/