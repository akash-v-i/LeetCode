class Solution {
    public boolean search(int[] arr, int x) {
        int left=0;
        int right=arr.length-1;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==x) return true;
            if(arr[mid]==arr[left] && arr[mid]==arr[right]){
                left++;
                right--;
                continue;
            }

            if(arr[left]<=arr[mid]){
                if(arr[left]<=x && x<=arr[mid]){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            else{
                if(arr[mid]<=x && x<=arr[right]){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
        }
        return false;
    }
}