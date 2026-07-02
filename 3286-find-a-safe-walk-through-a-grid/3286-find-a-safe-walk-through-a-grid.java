class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        health -= grid.get(0).get(0);
        if (health <= 0) return false;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.life - a.life);
        pq.add(new Pair(0, 0, health));

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = health;

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();

            int x = temp.x;
            int y = temp.y;
            int life = temp.life;

            if (x == n - 1 && y == m - 1) {
                return true;
            }

            // Up
            if (x - 1 >= 0) {
                int newLife = life - grid.get(x - 1).get(y);
                if (newLife > 0 && newLife > dp[x - 1][y]) {
                    dp[x - 1][y] = newLife;
                    pq.add(new Pair(x - 1, y, newLife));
                }
            }

            // Left
            if (y - 1 >= 0) {
                int newLife = life - grid.get(x).get(y - 1);
                if (newLife > 0 && newLife > dp[x][y - 1]) {
                    dp[x][y - 1] = newLife;
                    pq.add(new Pair(x, y - 1, newLife));
                }
            }

            // Down
            if (x + 1 < n) {
                int newLife = life - grid.get(x + 1).get(y);
                if (newLife > 0 && newLife > dp[x + 1][y]) {
                    dp[x + 1][y] = newLife;
                    pq.add(new Pair(x + 1, y, newLife));
                }
            }

            // Right
            if (y + 1 < m) {
                int newLife = life - grid.get(x).get(y + 1);
                if (newLife > 0 && newLife > dp[x][y + 1]) {
                    dp[x][y + 1] = newLife;
                    pq.add(new Pair(x, y + 1, newLife));
                }
            }
        }

        return false;
    }
}

class Pair {
    int x;
    int y;
    int life;

    Pair(int x, int y, int life) {
        this.x = x;
        this.y = y;
        this.life = life;
    }
}