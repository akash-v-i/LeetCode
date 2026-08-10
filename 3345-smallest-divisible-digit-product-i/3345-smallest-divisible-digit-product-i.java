class Solution {
    public int smallestNumber(int n, int t) {
        for(int x=n;x<=100;x++){
            int res=1;
            int temp=x;
            while(temp!=0){
                res*=(temp%10);
                temp/=10;
            }
            if(res%t==0) return x;
        }
        return 0;
    }
}