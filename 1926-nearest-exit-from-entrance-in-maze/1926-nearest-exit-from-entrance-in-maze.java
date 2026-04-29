class Solution {
    int n, m;

    public int nearestExit(char[][] maze, int[] entry) {
        int dir[] = { 0, 1, 0, -1, 0 };
        n = maze.length;
        m = maze[0].length;
        Queue<Pair> qe = new LinkedList<>();
        int vis[][] = new int[n][m];
        qe.add(new Pair(entry[0], entry[1]));
        int co = 0;
        vis[entry[0]][entry[1]] = 1;
        while (!qe.isEmpty()) {
            int size = qe.size();
            co++;
            for (int j = 0; j < size; j++) {
                Pair temp = qe.poll();
                int x = temp.x;
                int y = temp.y;
                for (int i = 0; i < 4; i++) {
                    int nr = x + dir[i];
                    int nc = y + dir[i + 1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == 0 && maze[nr][nc] == '.') {
                        vis[nr][nc] = 1;
                        if (nr == 0 || nc == 0 || nr == n - 1 || nc == m - 1 && (nr != entry[0] || nc != entry[1])) {
                            return co;
                        }
                        qe.add(new Pair(nr, nc));
                    }
                }
            }
        }
        return -1;
    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}