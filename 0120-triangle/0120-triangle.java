class Solution {
    public int minimumTotal(List<List<Integer>> al) {
        int n = al.size();
        List<List<Integer>> dp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> li = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                li.add(Integer.MAX_VALUE);
            }
            dp.add(li);
        }

        return find(al, dp, 0, 0, n);
    }

    public int find(List<List<Integer>> al, List<List<Integer>> dp, int row, int index, int n) {
        if (row == n - 1)
            return al.get(row).get(index);

        if (dp.get(row).get(index) != Integer.MAX_VALUE)
            return dp.get(row).get(index);
        int min =al.get(row).get(index)+ Math.min(find(al, dp, row + 1, index, n),find(al, dp, row + 1, index + 1, n));
        dp.get(row).set(index,min);

        return min;
    }
}