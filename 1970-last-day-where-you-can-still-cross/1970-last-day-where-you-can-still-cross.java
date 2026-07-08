class Solution {
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };

    public int latestDayToCross(int row, int col, int[][] cells) {

        int low = 1;
        int high = row * col;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canCross(mid, row, col, cells)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public boolean canCross(int day, int row, int col, int[][] cells) {

        int[][] grid = new int[row][col];
        for (int i = 0; i < day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = 1;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[row][col];

        for (int i = 0; i < col; i++) {
            if (grid[0][i] == 0) { 
                q.add(new int[] { 0, i });
                vis[0][i] = true;
            }
        }

        while (!q.isEmpty()) {

            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];

            if (r == row - 1)
                return true;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < row && nc >= 0 && nc < col && !vis[nr][nc] && grid[nr][nc] == 0) {
                    vis[nr][nc] = true;
                    q.add(new int[] { nr, nc });
                }
            }
        }
        return false;

    }
}