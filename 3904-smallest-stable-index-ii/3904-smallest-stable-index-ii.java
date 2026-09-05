class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        int pre[] = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            pre[i] = min;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            if (ans > max - pre[i]) {
                if (max - pre[i] > k)
                    continue;
                ans = max - pre[i];

                index = (index == -1) ? i : Math.min(i, index);
            }
        }
        return index;
    }
}