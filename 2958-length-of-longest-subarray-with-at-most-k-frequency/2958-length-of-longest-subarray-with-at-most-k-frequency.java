class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        int max=0;
        HashMap<Integer,Integer>hs=new HashMap<>();
        int left=0;
        for(int right=0;right<n;right++){
            hs.put(nums[right],hs.getOrDefault(nums[right],0)+1);

            if(hs.get(nums[right])>k){
                while(hs.containsKey(nums[right]) && hs.get(nums[right]) > k){
                    hs.put(nums[left],hs.get(nums[left])-1);
                    left++;
                }
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}