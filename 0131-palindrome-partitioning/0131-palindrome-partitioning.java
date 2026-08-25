class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>res=new ArrayList<>();
        find(s,0,new ArrayList<>(),res);
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
        int start=0;
        int end=str.length()-1;

        while(start<=end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}