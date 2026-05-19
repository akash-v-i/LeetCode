class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        HashSet<Integer>hs=new HashSet<>();
        for(int x:nums1){
            hs.add(x);
        }

        int co=0;
        for(int x:nums2){
            if(hs.contains(x)) return x;
        }
        return -1;
    }
}