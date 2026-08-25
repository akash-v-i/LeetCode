class Solution {
    public int minCut(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);

        return find(s, 0, dp) - 1;
    }

    public int find(String str, int index, int dp[]) {
        if (index == str.length()) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int min = Integer.MAX_VALUE;

        for (int i = index; i < str.length(); i++) {
            if (isPal(str, index, i)) {
                min = Math.min(
                    1 + find(str, i + 1, dp),
                    min
                );
            }
        }

        dp[index] = min;
        return min;
    }

    public boolean isPal(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}