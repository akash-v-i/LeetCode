class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return nums;
    }

    public void mergesort(int arr[],int l,int r){
        if(l<r){
            int mid=(l+r)/2;
            mergesort(arr,l,mid);
            mergesort(arr,mid+1,r);
            merge(arr,l,r,mid);
        }
    }

    public void merge(int arr[],int l,int r,int mid){
        int n1=(mid-l)+1;
        int n2=(r-mid);

        int arr1[]=new int[n1];
        int arr2[]=new int[n2];

        for(int i=0;i<n1;i++){
            arr1[i]=arr[l+i];
        }

        for(int i=0;i<n2;i++){
            arr2[i]=arr[mid+1+i];
        }

        int i=0;
        int j=0;
        int k=l;
        while(i<n1 && j<n2){
            if(arr1[i]<=arr2[j]){
                arr[k]=arr1[i++];
            }
            else{
                arr[k]=arr2[j++];
            }
            k++;
        }
        while(i<n1){
            arr[k++]=arr1[i++];
        }
        
        while(j<n2){
            arr[k++]=arr2[j++];
        }
    }
}