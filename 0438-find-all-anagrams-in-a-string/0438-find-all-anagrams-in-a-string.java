class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> last = new ArrayList<>();
        int arr[] = new int[26];
        for (char ch : p.toCharArray()) {
            arr[ch - 'a']++;
        }

        int arr1[] = new int[26];
        int i=0;
        for ( i = 0; i < s.length(); i++) {
            if (i < p.length()) {
                arr1[s.charAt(i) - 'a']++;
            } else {
                if (Arrays.equals(arr, arr1)) {
                    last.add(i - p.length());
                }
                arr1[s.charAt(i - p.length()) - 'a']--;
                arr1[s.charAt(i) - 'a']++;
            }
        }
        if(Arrays.equals(arr, arr1)){
            last.add(i - p.length());
        }
        return last;
    }
}