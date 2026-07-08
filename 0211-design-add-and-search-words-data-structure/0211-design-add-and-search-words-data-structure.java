class WordDictionary {
    WordDictionary arr[];
    boolean flag;

    public WordDictionary() {
        arr= new WordDictionary[26];
        flag=false;
    }
    
    public void addWord(String word) {
        WordDictionary curr=this;

        for(char ch:word.toCharArray()){
            int idx=ch-'a';
            if(curr.arr[idx]==null){
                curr.arr[idx]=new WordDictionary();
            }
            curr=curr.arr[idx];
        }
        curr.flag=true;
    }
    
    public boolean search(String word) {
        WordDictionary curr=this;
        return find(word,0,curr);
        
    }
    private boolean find(String word,int index,WordDictionary root){

        if(index==word.length() ){
            return root.flag;
        }
        if(word.charAt(index)=='.'){
            boolean ans=false;
            for(int i=0;i<26;i++){
                if(root.arr[i]!=null){
                    ans=ans||find(word,index+1,root.arr[i]);
                }
            }
            return ans;
        }
        else{
            int idx=word.charAt(index)-'a';
            if(root.arr[idx]==null) return false;
            return find(word,index+1,root.arr[idx]);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */