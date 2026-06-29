class Solution {
    public int maxProfit(int[] prices) {
        int min=10000;
        int ans=0;
        for(int x:prices){
            ans=Math.max(ans,x-min);
            min=Math.min(min,x);
        }
        return ans;
    }
}