class Solution {
    public boolean canPartition(int[] arr) {
        int sum=0;
        for(int x:arr){
            sum+=x;
        }

        if(sum%2==1) return false;
        Boolean dp[][]=new Boolean[arr.length][sum/2 +1];
        return find(arr,0,sum/2,dp);
    }

    public boolean find(int arr[],int index,int sum,Boolean dp[][]){
        if(sum==0) return true;
        
        if(index==arr.length || sum<0) return false;

        if(dp[index][sum]!=null) return dp[index][sum];
        dp[index][sum]=find(arr,index+1,sum-arr[index],dp)||find(arr,index+1,sum,dp);
        return dp[index][sum];
    }
}