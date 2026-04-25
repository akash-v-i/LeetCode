class Solution {
    public int maxArea(int[] height) {
        int a=0;
        int b=height.length-1;
        int max=0;
        while(a<b){
            int min=Math.min(height[a],height[b]);
            max=Math.max(max,Math.abs(a-b)*min);

            if(height[a]<height[b]){
                a++;
            }
            else{
                b--;
            }
        }
        return max;
    }
}
//[1,8,6,2,5,4,8,3,7]
// 0 1 2 3 4 5 6 7 8


/*
int a=0;
        int b=height.length-1;
        int max=0;
        while(a<b){
            int min=Math.min(height[a],height[b]);
            max=Math.max(max,Math.abs(a-b)*min);
            if(height[a]<height[b]){
                a++;
            }
            else{
                b--;
            }
        }
        return max;
*/