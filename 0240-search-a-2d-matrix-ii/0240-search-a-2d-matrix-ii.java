class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int arr[]:matrix){
            int st=0;
            int end=arr.length-1;
            while(st<=end){
                int mid=(st+end)/2;
                if(arr[mid]<target){
                    st=mid+1;
                }
                else if(arr[mid]>target){
                    end=mid-1;
                }
                else{
                    return true;
                }
            }
        }
        return false;
    }
}