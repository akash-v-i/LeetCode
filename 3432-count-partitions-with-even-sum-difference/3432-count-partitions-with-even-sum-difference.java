class Solution {
    public int countPartitions(int[] nums) {
        int total=0;
        for(int x:nums){
            total+=x;
        }
        int co=0;
        int sum=0;
        for(int x:nums){
            sum+=x;

            if((total-2*sum)%2==0){
                co++;
            }
        }
        return co==0?0:co-1;
    }
}