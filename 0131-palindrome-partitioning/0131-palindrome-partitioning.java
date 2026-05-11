class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>res=new ArrayList<>();
        List<String>al=new ArrayList<>();
        find(s,0,al,res);
        return res;
    }

    public void find(String str,int index,List<String>al,List<List<String>>res){
        if(index==str.length()){
            res.add(new ArrayList<>(al));
            return;
        }

        for(int i=index;i<str.length();i++){
            if(isPal(str.substring(index,i+1))){
                al.add(str.substring(index,i+1));
                find(str,i+1,al,res);
                al.remove(al.size()-1);
            }
        }
    }
    public boolean isPal(String str){
        int st=0;
        int end=str.length()-1;
        while(st<end){
            if(str.charAt(st)!=str.charAt(end)){
                return false;
            }
            st++;
            end--;
        }
        return true;
    }
}