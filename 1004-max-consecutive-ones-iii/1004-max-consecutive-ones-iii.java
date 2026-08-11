class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        int right=0;
        int temp=k;
        int max=0;
        while(right<n){
            if(nums[right]==0){
                temp--;

                if(temp==-1){
                    while(nums[left]!=0){
                        left++;
                    }
                    left++;
                    temp=0;
                }
            }
            max=Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}