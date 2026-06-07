class Solution {
    public int[] findErrorNums(int[] nums) {

        int n=nums.length;
        int sum=0;
        for(int x:nums){
            sum+=x;
        }

        int actualsum=(n*(n+1))/2;
        int eq1=sum-actualsum;

        int sqr=0;
        int actualsqr=0;
        for(int i=0;i<n;i++){
            sqr+=(nums[i]*nums[i]);
            actualsqr+=((i+1)*(i+1));
        }
        int eq2=sqr-actualsqr;

        int eq3=eq2/eq1;
        int a=(eq3+eq1)/2;
        int b=eq3-a;
        return new int[]{a,b};
    }
}

/*

Using Mathematical way


use formulas like 
(1+2+....+N)=(N*(N+1))/2
(X^2 - Y^2)=(X+Y)*(X-Y)
*/