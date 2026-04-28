class Solution {
    public int minMutation(String start, String end, String[] bank) {
        int n=bank.length;
        int vis[]=new int[n];

        Queue<String>qe=new LinkedList<>();
        qe.add(start);
        int co=0;
        while(!qe.isEmpty()){
            int m=qe.size();
            co++;
            for(int i=0;i<m;i++){
                String x=qe.poll();
                for(int j=0;j<n;j++){
                    if(vis[j]==0 && find(x,bank[j])){
                        vis[j]=1;
                        if(bank[j].equals(end)) return co;
                        qe.add(bank[j]);
                    }
                }
            }
        }
        return -1;
    }

    public boolean find(String a,String b){
        int diff=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)) diff++;

            if(diff>1) return false;
        }
        return true;
    }
    
}