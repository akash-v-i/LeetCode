class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashMap<Character, Integer> hs = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hs.containsKey(ch)) {
                left = Math.max(left, hs.get(ch) + 1);
            }

            max = Math.max(max, i - left + 1);
            hs.put(ch, i);
        }

        return max;
    }
}