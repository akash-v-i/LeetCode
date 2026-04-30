class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        find(nums,0,new ArrayList<>(),ans);
        return ans;
    }
    public void find(int nums[],int st,List<Integer>al,List<List<Integer>>ans){
        ans.add(new ArrayList<>(al));
        for(int i=st;i<nums.length;i++){
            al.add(nums[i]);
            find(nums,i+1,al,ans);
            al.remove(al.size()-1);
        }
    }
}