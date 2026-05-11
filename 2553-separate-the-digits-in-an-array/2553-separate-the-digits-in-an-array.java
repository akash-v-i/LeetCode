class Solution {
    public int[] separateDigits(int[] nums) {
        StringBuilder st=new StringBuilder();
        for(int x:nums){
            st.append(x);
        }
        int arr[]=new int[st.length()];
        int i=0;
        for(char ch:st.toString().toCharArray()){
            arr[i++]=ch-'0';
        }
        return arr;
    }
}