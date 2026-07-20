class Solution {
    public int[] rearrangeArray(int[] arr) {
        int ans[]=new int[arr.length];

        int positiveIndex=0;
        int negativeIndex=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=0){
                ans[positiveIndex]=arr[i];
                positiveIndex+=2;
            }
            else{
                ans[negativeIndex]=arr[i];
                negativeIndex+=2;
            }
        }
        return ans;
    }
}