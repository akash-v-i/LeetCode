class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer>hs=new HashSet<>();
        Arrays.sort(nums);
        for(int x:nums){
            if(!hs.add(x)){
                return true;
            }
        }
        return false;
    }
}