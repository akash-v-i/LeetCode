class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>al=new ArrayList<>();
        boolean board[][]=new boolean[n][n];
        queen(board,0,al);
        return al;
    }

    public static void queen(boolean board[][],int r,List<List<String>>al){
        if(r==board.length){
            al.add(display(board));
            return;
        }
        for(int i=0;i<board.length;i++){
            if(issafe(board,r,i)){
                board[r][i]=true;
                queen(board,r+1,al);
                board[r][i]=false;
            }
        }
    }
    public static boolean issafe(boolean board[][],int r,int c){
        //check up,right diag,left diag
        //up
        for(int i=0;i<r;i++){
            if(board[i][c]){
                return false;
            }
        }
        //right diag
        int min=Math.min(r,board.length-1-c);
        for(int i=1;i<=min;i++){
            if(board[r-i][c+i]){
                return false;
            }
        }
        min=Math.min(r,c);
        for(int i=0;i<=min;i++){
            if(board[r-i][c-i]){
                return false;
            }
        }
        return true;
    }
    public static List<String> display(boolean board[][]){
        List<String>ans=new ArrayList<>();

        for(int i=0;i<board.length;i++){
            StringBuilder al=new StringBuilder();
            for(int j=0;j<board.length;j++){
                if(board[i][j]){
                    al.append("Q");
                }
                else{
                    al.append(".");
                }
            }
            ans.add(al.toString());
        }
        return ans;
    }
}