class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int prev=nums[0];
        int prev2=0;
        for(int i=1;i<n;i++){
            int take = prev2+nums[i];
            int nottake=0+prev;
            int curr=Math.max(take,nottake);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}