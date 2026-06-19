class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return find(nums,dp,n,n-1);
    }
    public int find(int nums[],int dp[],int n,int index){
        if(index==0) return nums[0];

        if(index<0) return 0;

        if(dp[index]!=-1) return dp[index];

        int pick=nums[index]+find(nums,dp,n,index-2);
        int notpick=0+find(nums,dp,n,index-1);
        dp[index]=Math.max(pick,notpick);

        return dp[index];
    }
}