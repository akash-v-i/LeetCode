class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer, Integer> hs = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            hs.put(fruits[right], hs.getOrDefault(fruits[right], 0) + 1);
            if (hs.size() > 2) {
                while (hs.size() > 2) {
                    hs.put(fruits[left], hs.get(fruits[left]) - 1);
                    if (hs.get(fruits[left]) == 0) {
                        hs.remove(fruits[left]);
                    }
                    left++;
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}