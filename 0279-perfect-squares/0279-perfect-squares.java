class Solution {
    public int numSquares(int n) {
        List<Integer>ls=new ArrayList<>();
        for(int i=1;i<100000;i++){
            if(i*i>n){
                break;
            }
            else if(i*i==n) return 1;
            ls.add(i*i);
        }
        int dp[][]=new int[ls.size()][n+1];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }

        return find(ls,0,n,dp);
    }

    public int find(List<Integer>ls,int index,int sum,int dp[][]){
        if(sum==0) return sum;
        if(sum<0 || index==ls.size()) return 10000;

        if(dp[index][sum]!=-1) return dp[index][sum];

        int pick=1+find(ls,index,sum-ls.get(index),dp);
        int not=find(ls,index+1,sum,dp);
        dp[index][sum]=Math.min(pick,not);
        return dp[index][sum];
    }
}