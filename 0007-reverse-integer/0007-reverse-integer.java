class Solution {
    public int reverse(int x) {
        long r=0;
        int a=x;
        if(x<0){
            x=Math.abs(x);
            while(x>0){
            int re=x%10;
            r=(r*10)+re;
            x=x/10;
            }
            if( r > 2147483647){
                return 0;
            }
            else{
                int b=(int)r;
                return b*-1;
            }
        }
        else{
            while(x>0){
                int re=x%10;
            r=(r*10)+re;
            x=x/10;
            }
            if(r > 2147483647){
                return 0;
            }
            else{
                int b=(int)r;
                return b;
            }
            

        }
    }
}