class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();

        find(n,0,0,"",ans);
        return ans;
    }
    public void find(int n,int open,int closed,String str,List<String>ans){
        if(open==n && closed==n){
            ans.add(str);
            return;
        }

        if(closed<open  && closed<=n){
            find(n,open,closed+1,str+')',ans);
        }

        if(open<=n){
            find(n,open+1,closed,str+'(',ans);
        }
    }
}