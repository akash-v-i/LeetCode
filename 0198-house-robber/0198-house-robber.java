class Solution {
    public int rob(int[] nums) {
        
        int n=nums.length;
        if(n<2){
            return nums[0];
        }
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            if(i<2){
                dp[i]=nums[i];
            }
            else{
                int a=(i-2>=0)?(dp[i-2]):0;
                int b=(i-3>=0)?(dp[i-3]):0;
                dp[i]=nums[i]+Math.max(a,b);
            }
        }

        return Math.max(dp[n-1],dp[n-2]);
    }
}