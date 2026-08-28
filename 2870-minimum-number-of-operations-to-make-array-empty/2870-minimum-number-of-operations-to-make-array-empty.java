class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int x : nums) {
            hs.put(x, hs.getOrDefault(x, 0) + 1);
        }
        int co = 0;
        for (int x : hs.values()) {
            if (x == 1)
                return -1;

            if (x % 3 == 0)
                co += x / 3;
            else
                co += x / 3 + 1;
        }
        return co;
    }
}