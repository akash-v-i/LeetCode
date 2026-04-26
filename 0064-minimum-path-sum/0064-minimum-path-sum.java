class Solution {
    int n, m;

    public int minPathSum(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        if(n==1 && m==1) return grid[0][0];
        int dp[][] = new int[n][m];
        dp[n-1][m-1]=grid[n-1][m-1];
        dp[0][0] = grid[0][0]+Math.min(find(grid, dp, 1, 0), find(grid, dp, 0, 1));
        return dp[0][0];
    }

    public int find(int grid[][], int dp[][], int x, int y) {

        if (x == n - 1 && y == m - 1)
            return grid[n - 1][m - 1];

        if (x >= n || x < 0 || y >= m || y < 0)
            return Integer.MAX_VALUE;

        if (dp[x][y] != 0)
            return dp[x][y];


        dp[x][y] = grid[x][y] + Math.min(find(grid, dp, x + 1, y), find(grid, dp, x, y + 1));
        return dp[x][y];
    }
}

/*
00 01 02
10 11 12
20 21 22
*/