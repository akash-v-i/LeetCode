class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer>st=new Stack<>();
        int n=arr.length;
        int ans[]=new int[n];
        int index=n-1;
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                ans[index--]=0;
                st.push(i);
            }
            else{
                while(!st.isEmpty() && arr[i]>=arr[st.peek()]){
                    st.pop();
                }

                if(st.isEmpty()){
                    ans[index--]=0;
                    st.push(i);
                }
                else{
                    ans[index--]=st.peek()-i;
                    st.push(i);
                }
            }
        }
        return ans;
    }
}