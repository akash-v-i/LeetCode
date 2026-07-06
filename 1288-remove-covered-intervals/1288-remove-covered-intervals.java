class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]); 
            }
            return Integer.compare(a[0], b[0]);
        });

        int count=0;
        int max=0;

        for(int arr[]:intervals){
            int end = arr[1];
            if (end > max) {
                count++;
                max = end;
            }
        }
        return count;
    }
}