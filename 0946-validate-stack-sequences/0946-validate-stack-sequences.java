class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer>st=new Stack<>();
        int index=0;
        int n=pushed.length;
        for(int i=0;i<n;i++){
            st.push(pushed[i]);
            while(!st.isEmpty() && index<n && st.peek()==popped[index]){
                index++;
                System.out.println(st.pop());
            }
        }
        System.out.print(st.size());
        return st.isEmpty();
    }
}