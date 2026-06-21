class Solution {
    public int findTargetSumWays(int[] arr, int x) {
        int n=arr.length;
        HashMap<String,Integer>dp=new HashMap<>();
        return find(arr,0,x,0,n,dp);
    }
    public int find(int arr[], int index, int target, int sum, int n, HashMap<String,Integer>dp){

        if (sum==target && index==n) return 1;

        if (index>=n) return 0;

        if(dp.containsKey(index+"#"+sum)){
            return dp.get(index+"#"+sum);
        }

        int positive=find(arr,index+1,target,sum+arr[index],n,dp);
        int negative=find(arr,index+1,target,sum-arr[index],n,dp);
        dp.put(index+"#"+sum,positive+negative);
        return positive+negative;
    }
}