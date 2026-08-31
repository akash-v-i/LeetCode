class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>al=new ArrayList<>();
        find(al,new ArrayList<>(),1,n,k);
        return al;
    }
    public void find(List<List<Integer>>al,List<Integer>li,int st,int n,int k){
        if(li.size()==k){
            al.add(new ArrayList<>(li));
            return;
        }
        for(int i=st;i<=n;i++){
            li.add(i);
            find(al,li,i+1,n,k);
            li.removeLast();
        }
    }
}