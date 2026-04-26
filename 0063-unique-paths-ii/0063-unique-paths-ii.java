class Solution {
    int dp[][];
    int n, m;

    public int uniquePathsWithObstacles(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        if(grid[0][0]==1) return 0;
        if (n == 1 && m == 1) {
            if (grid[0][0] == 1)
                return 0;
            else
                return 1;
        }

        dp = new int[n][m];
        dp[0][0] = find(grid, 0, 1) + find(grid, 1, 0);
        return dp[0][0];
    }

    public int find(int grid[][], int x, int y) {
        if (x >= n || x < 0 || y >= m || y < 0 || grid[x][y] == 1)
            return 0;

        if (x == n - 1 && y == m - 1)
            return 1;

        if(dp[x][y]!=0) return dp[x][y];

        dp[x][y] = find(grid, x, y + 1) + find(grid, x + 1, y);
        return dp[x][y];
    }
}
/*
00 01 02
10 11 12
20 21 22
*/