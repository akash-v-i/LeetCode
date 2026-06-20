class Solution {
    public int minimumTotal(List<List<Integer>> al) {
        List<List<Integer>>dp=new ArrayList<>();
        int n=al.size();
        for(int i=0;i<n;i++){
            List<Integer>li=new ArrayList<>();
            for(int j=0;j<=i;j++){
                li.add(Integer.MAX_VALUE);
            }
            dp.add(li);
        }
        return find(al,0,n,0,dp);
    }
    public static int find(List<List<Integer>>al,int row,int n,int index,List<List<Integer>>dp){
        if (row==n-1) return al.get(row).get(index);
        
        if(dp.get(row).get(index)!=Integer.MAX_VALUE) return dp.get(row).get(index);

        int min=al.get(row).get(index)+Math.min(find(al,row+1,n,index,dp),find(al,row+1,n,index+1,dp));
        dp.get(row).set(index,min);
        return min;
    }
}
