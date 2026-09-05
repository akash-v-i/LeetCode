class Solution {
    public int findMinArrowShots(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int arrow = 1;
        for (int arr[] : points) {
            pq.add(arr);
        }
        int dummy[] = pq.poll();
        int max = dummy[1];
        while (!pq.isEmpty()) {
            dummy = pq.poll();
            if (dummy[0] <= max) {
                max = Math.min(max, dummy[1]);
            } else {
                arrow++;
                max = dummy[1];
            }
        }
        return arrow;

    }
}