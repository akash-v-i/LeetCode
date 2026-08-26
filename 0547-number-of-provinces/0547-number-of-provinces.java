    class Solution {
        public int findCircleNum(int[][] isConnected) {
            ArrayList<ArrayList<Integer>> al = new ArrayList<>();
            for (int i = 0; i < isConnected.length; i++) {
                al.add(new ArrayList<>());
            }
            for (int i = 0; i < isConnected.length; i++) {
                for (int j = 0; j < isConnected[0].length; j++) {
                    if (isConnected[i][j] == 1 && i != j) {
                        al.get(i).add(j);
                        al.get(j).add(i);
                    }
                }
            }
            boolean vis[]=new boolean[isConnected.length];
            int co=0;
            for(int i=0;i<isConnected.length;i++){
                if(!vis[i]){
                    DFS(al,i,vis);
                    co++;
                }
            }
            return co;
        }

        public static void DFS(ArrayList<ArrayList<Integer>> al,int x,boolean vis[]){
            vis[x]=true;
            for(int a:al.get(x)){
                if(!vis[a]){
                    vis[a]=true;
                    DFS(al,a,vis);
                }
            }
        }
    }