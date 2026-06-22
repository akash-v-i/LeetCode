class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String,Integer>dp=new HashMap<>();
        return find(nums,target,0,0,dp);
    }
    public int find(int nums[],int target,int index,int sum,HashMap<String,Integer>dp){
        if(index==nums.length && target==sum) return 1;
        if(index>=nums.length) return 0;

        if(dp.containsKey(index+"#"+sum)) return dp.get(index+"#"+sum);
        int positive=find(nums,target,index+1,sum+nums[index],dp);
        int negative=find(nums,target,index+1,sum-nums[index],dp);
        dp.put(index+"#"+sum,positive+negative);
        return positive+negative;
    }
}