class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int take_first=find(nums,n-1,1);
        int take_last=find(nums,n,2);
        return Math.max(take_first,take_last);
    }
    public int find(int nums[],int n ,int index){
        int prev=nums[index-1];
        int prev2=0;

        for(int i=index;i<n;i++){
            int take=nums[i]+prev2;
            int nottake=0+prev;
            int curr=Math.max(take,nottake);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}