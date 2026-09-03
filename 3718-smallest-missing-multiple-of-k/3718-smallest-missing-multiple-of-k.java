class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer>hs=new HashSet<>();
        for(int x:nums){
            hs.add(x);
        }
        for(int i=1;i<=10000;i++){
            if(!hs.contains(k*i)){
                return k*i;
            }
        }
        return 0;
    }
}