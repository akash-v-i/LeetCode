class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int a:nums){
            sum+=a;
        }
        if(sum%2==1) return false;

        Boolean dp[][]=new Boolean[nums.length][sum/2 +1];
        return find(nums,sum/2,0,0,nums.length,dp);
    }
    public boolean find(int nums[],int x,int index,int sum,int n,Boolean dp[][]){

        if(sum==x) return true;

        if(index>=n || sum>x) return false;

        if(dp[index][sum]!=null) return dp[index][sum];

        dp[index][sum]=find(nums,x,index+1,sum+nums[index],n,dp) || find(nums,x,index+1,sum,n,dp);
        return dp[index][sum];
    }
}