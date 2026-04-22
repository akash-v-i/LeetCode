class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        PriorityQueue<Pair>qe=new PriorityQueue<>((a,b)->a.dist-b.dist);
        qe.add(new Pair(0,0));
        int total=0;
        boolean vis[]=new boolean[n];
        while(!qe.isEmpty()){
            Pair temp=qe.poll();
            int x=temp.index;
            int dist=temp.dist;
            if(vis[x]) continue;

            vis[x]=true;
            total+=dist;
            for(int i=0;i<n;i++){
                if(!vis[i]){
                    int cost=Math.abs(points[i][0]-points[x][0])+Math.abs(points[i][1]-points[x][1]);
                    qe.add(new Pair(i,cost));
                }
            }
        }
        return total;
    }
}
class Pair{
    int index,dist;
    Pair(int x,int dist){
        this.index=x;
        this.dist=dist;
    }
}