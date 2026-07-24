class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>ans=new ArrayList<>();

        HashMap<String,List<String>>hs=new HashMap<>();

        for(String x:strs){
            int arr[]=new int[26];
            for(char ch:x.toCharArray()){
                arr[ch-'a']++;
            }

            String key=Arrays.toString(arr);
            hs.putIfAbsent(key,new ArrayList<>());

            hs.get(key).add(x);
        }
        for(List<String>li:hs.values()){
            ans.add(li);
        }
        return ans;
    }
}