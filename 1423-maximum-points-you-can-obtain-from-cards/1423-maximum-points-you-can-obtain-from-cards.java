class Solution {
    public int maxScore(int[] points, int k) {
        int n=points.length;
        int max=0;
        int leftsum=0;
        for(int i=0;i<k;i++){
            leftsum+=points[i];
        }
        max=Math.max(max,leftsum);
        int rightsum=0;
        for(int i=0;i<k;i++){
            leftsum-=points[k-i-1];
            rightsum+=points[n-i-1];
            max=Math.max(max,leftsum+rightsum);
        }
        return max;

    }
}