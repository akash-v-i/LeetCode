class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return find(nums,target,0,0);
    }
    public int find(int nums[],int target,int index,int sum){
        if(index==nums.length && target==sum) return 1;

        if(index>=nums.length) return 0;
        int positive=find(nums,target,index+1,sum+nums[index]);
        int negative=find(nums,target,index+1,sum-nums[index]);
        return positive+negative;
    }
}