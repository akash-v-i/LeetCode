class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String>hs=new HashSet<>();
        int max=0;
        for(int i=0;i<arr1.length;i++){
            String x=Integer.toString(arr1[i]);
            for(int j=1;j<=x.length();j++){
                hs.add(x.substring(0,j));
            }
        }

        for(int i=0;i<arr2.length;i++){
            String x=Integer.toString(arr2[i]);
            for(int j=1;j<=x.length();j++){
                if(hs.contains(x.substring(0,j))){
                    max=Math.max(max,j);
                }
            }
        }
        return max;
    }
}