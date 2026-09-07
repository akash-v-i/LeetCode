class Solution {
    public int calculate(String s) {
        Stack<Integer>st=new Stack<>();
        Stack<Character>ch=new Stack<>();
        int index=0;
        while(index<s.length()){
            if(s.charAt(index)==' '){
                index++;
                continue;
            }

            if(Character.isDigit(s.charAt(index))){
                int val=0;
                while(index<s.length() && Character.isDigit(s.charAt(index))){
                    val=(val*10)+(s.charAt(index)-'0');
                    index++;
                }
                if(!ch.isEmpty() && (ch.peek()=='*' || ch.peek()=='/')){
                    if(ch.peek()=='*'){
                        int temp=st.pop();
                        ch.pop();
                        st.push(temp*val);
                    }
                    else if(ch.peek()=='/'){
                        int temp=st.pop();
                        ch.pop();
                        st.push(temp/val);
                    }
                    
                }
                else{
                    if(!ch.isEmpty() && ch.peek()=='-'){
                        val*=-1;
                    }
                    st.push(val);
                }
            }
            else if(index<s.length() && s.charAt(index)!=' '){
                ch.push(s.charAt(index));
                index++;
            }
        }
        while(!ch.isEmpty()){
            int a =st.pop();
            int b=st.pop();
            char cha=ch.pop();
            st.push(a+b);
        }
        return st.pop();
    }
}