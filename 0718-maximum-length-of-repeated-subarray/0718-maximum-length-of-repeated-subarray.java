class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums2.length;
        int[] dp = new int[m + 1];
        int maxLength = 0;
        
        for (int val1 : nums1) {
            for (int j = m; j >= 1; j--) {
                if (val1 == nums2[j - 1]) {
                    dp[j] = 1 + dp[j - 1];
                    maxLength = Math.max(maxLength, dp[j]);
                } else {
                    dp[j] = 0; 
                }
            }
        }
        
        return maxLength;
    }
}
