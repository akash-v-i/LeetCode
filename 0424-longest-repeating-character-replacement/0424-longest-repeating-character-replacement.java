class Solution {
    public int characterReplacement(String s, int k) {
        int max=0;
        int maxfre=0;
        int left=0;
        HashMap<Character,Integer>hs=new HashMap<>();
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            hs.put(ch,hs.getOrDefault(ch,0)+1);
            maxfre=Math.max(maxfre,hs.get(ch));
            int len=right-left+1;
            if((len-maxfre)<=k){
                max=Math.max(len,max);
            }
            else{
                while(left<=right && len-maxfre>k){
                    char a=s.charAt(left++);
                    hs.put(a,hs.get(a)-1);
                    maxfre=0;
                    for(int x:hs.values()){
                        maxfre=Math.max(maxfre,x);
                    }
                    len=left-right+1;
                }
            }
        }
        return max;
    }
}