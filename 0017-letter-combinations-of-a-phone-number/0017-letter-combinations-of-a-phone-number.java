class Solution {
    public List<String> letterCombinations(String str) {
        List<String>st=new ArrayList<>();
        find(str,str.length(),0,st,"");
        return st;
    }

    public static void find(String str,int n,int idx,List<String>al,String ans){
        if (idx==n){
            al.add(ans);
            return;
        }

        if (str.charAt(idx)!='8' && str.charAt(idx)!='9'){
            int st=((str.charAt(idx)-'0')-2)*3;
            int end=st+3+((str.charAt(idx)=='7')?1:0);
            for (int i = st; i <end ; i++) {
                find(str,n,idx+1,al,ans+((char)('a'+i)));
            }
        }
        else {
            int st=((str.charAt(idx)-'0')-2)*3 +1;
            int end=st+3+((str.charAt(idx)=='9')?1:0);
            for (int i = st; i <end ; i++) {
                find(str,n,idx+1,al,ans+((char)('a'+i)));
            }
        }
    }
}