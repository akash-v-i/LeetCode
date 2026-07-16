class Solution {
    public int hIndex(int[] arr) {
        Arrays.sort(arr);
        int ans=0;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]<(ans+1)){
                break;
            }
            ans++;
        }
        return ans;
    }
}
//[0 1 3 5 6]