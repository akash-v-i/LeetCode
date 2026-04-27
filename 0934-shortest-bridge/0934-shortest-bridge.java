class Solution {
    Queue<Pair> qe;
    int n, m;
    int diff[] = { 0, 1, 0, -1, 0 };

    public int shortestBridge(int[][] grid) {
        qe = new LinkedList<>();
        n = grid.length;
        m = grid[0].length;
        boolean flag = false;
        int vis[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, vis, grid);
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
        }
        int co = 0;
        while (!qe.isEmpty()) {
            int size = qe.size();
            for (int i = 0; i < size; i++) {
                Pair temp = qe.poll();
                int x = temp.x;
                int y = temp.y;

                vis[x][y] = 1;
                for (int j = 0; j < 4; j++) {
                    int nr = x + diff[j];
                    int nc = y + diff[j + 1];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == 0 && grid[nr][nc]==1){
                        return co;
                    }

                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == 0) {
                        vis[nr][nc] = 1;
                        qe.add(new Pair(nr, nc));
                    }
                }
            }
            co++;
        }
        return 0;
    }

    public void dfs(int x, int y, int vis[][], int grid[][]) {

        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0 || vis[x][y] == 1)
            return;

        vis[x][y] = 1;
        qe.add(new Pair(x, y));
        for (int i = 0; i < 4; i++) {
            int nr = x + diff[i];
            int nc = y + diff[i + 1];
            dfs(nr, nc, vis, grid);
        }
    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
/*
[1,1,0]
[1,0,0]
[0,0,1]
*/