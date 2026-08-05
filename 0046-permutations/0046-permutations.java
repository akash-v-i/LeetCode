class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        boolean vis[]=new boolean[nums.length];
        List<List<Integer>>al=new ArrayList<>();
        find(nums,al,new ArrayList<>(),vis);
        return al;  
    }

    public void find(int arr[],List<List<Integer>>al,List<Integer>li,boolean vis[]){

        if(li.size()==arr.length){
            al.add(new ArrayList<>(li));
            return;
        }

        for(int i=0;i<arr.length;i++){

            if(i>0 && arr[i]==arr[i-1] && !vis[i]){
                continue;
            }
            if(vis[i]) continue;

            li.add(arr[i]);
            vis[i]=true;
            find(arr,al,li,vis);

            vis[i]=false;
            li.removeLast();
        }
    }
}