class Solution {
    public int minOperations(int[][] grid, int x) {
         int m = grid.length, n = grid[0].length;
        int[] values = new int[m * n];

        
        int index = 0;
        for (int[] row : grid) {
            for (int num : row) {
                values[index++] = num;
            }
        }

        
        for (int num : values) {
            if ((num - values[0]) % x != 0) {
                return -1; 
            }
        }

        Arrays.sort(values);
        int median = values[values.length / 2];

       
        int operations = 0;
        for (int num : values) {
            operations += Math.abs(num - median) / x;
        }

        return operations;
    }
}