class Solution {
    public int countPrimes(int n) {
        boolean prime[]=new boolean[n+1];
        Arrays.fill(prime,true);
        for(int i=2;i*i<=n;i++){
            if(prime[i]){
                for(int j=i*i;j<=n;j+=i){
                    prime[j]=false;
                }
            }
        }
        int co=0;
        for(int i=2;i<n;i++){
            if(prime[i]) co++;
        }
        return co;
    }
}