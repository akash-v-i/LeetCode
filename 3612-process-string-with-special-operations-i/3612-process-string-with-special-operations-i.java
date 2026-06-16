class Solution {
    public String processStr(String s) {
        StringBuilder st=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch=='*'){
                if(st.length()>0){
                    st.deleteCharAt(st.length() - 1);
                }
            }
            else if(ch=='#'){
                st.append(st.toString());
            }
            else if(ch=='%'){
                st.reverse();
            }
            else{
                st.append(ch);
            }
        }
        return st.toString();
    }
}