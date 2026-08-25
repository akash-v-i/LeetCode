class Solution {
    public boolean wordBreak(String s, List<String> ls) {
        int n=s.length();
        Set<String>hs=new HashSet<>();
        int max=0;
        for(String str:ls){
            hs.add(str);
            max=Math.max(max,str.length());
        }
        boolean  dp[]=new boolean[n+1];
        dp[0]=true; 

        for(int i=1;i<=s.length();i++){
            
            for(int j=i-1;j>=Math.max(0,i-max);j--){
                if(dp[j] && hs.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
//l e e t c o d e
//0 1 2 3 4 5 6 7
//4