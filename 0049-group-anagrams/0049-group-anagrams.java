class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>ans=new ArrayList<>();
        Map<String,List<String>>hs=new HashMap<>();
        for(String x:strs){
            char ch[]=x.toCharArray();
            Arrays.sort(ch);
            String key=Arrays.toString(ch);
            hs.putIfAbsent(key,new ArrayList<>());
            hs.get(key).add(x);
        }
        for(List<String>al:hs.values()){
            ans.add(al);
        }
        return ans;
    }
}