class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder st = new StringBuilder(s);
        String rev = st.reverse().toString();

        int a = s.length();
        int b = a;
        int dp[][] = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                dp[i][j] = -1;
            }
        }
        return find(s, rev, a - 1, b - 1, dp);
    }

    public int find(String a, String b, int x, int y, int dp[][]) {
        if (x < 0 || y < 0) {
            return 0;
        }

        if (dp[x][y] != -1)
            return dp[x][y];
        if (a.charAt(x) == b.charAt(y)) {
            dp[x][y] = 1 + find(a, b, x - 1, y - 1, dp);
            return dp[x][y];
        }
        dp[x][y] = Math.max(find(a, b, x, y - 1, dp), find(a, b, x - 1, y, dp));
        return dp[x][y];
    }
}