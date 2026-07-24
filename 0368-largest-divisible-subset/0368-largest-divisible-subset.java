class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int hash[] = new int[n];
        for (int i = 0; i < n; i++) {
            hash[i] = i;
        }
        Arrays.sort(nums);
        Arrays.fill(dp, 1);
        int maxi = 1;
        int maxidx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }

            if (dp[i] > maxi) {
                maxi = dp[i];
                maxidx = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (hash[maxidx] != maxidx) {
            ans.add(nums[maxidx]);
            maxidx = hash[maxidx];
        }
        ans.add(nums[maxidx]);
        return ans;
    }
}