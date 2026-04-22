class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>hs=new HashMap<>();

        for(String x:strs){

            char ch[]=x.toCharArray();
            Arrays.sort(ch);
            String str=Arrays.toString(ch);
            hs.putIfAbsent(str,new ArrayList<>());
            hs.get(str).add(x);
        }
        List<List<String>>li=new ArrayList<>();
        for(List<String>a:hs.values()){
            li.add(a);
        }
        return li;
    }
}