class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.first - b.first);
        Stack<Pair>ans=new Stack<>();
        pq.add(new Pair(newInterval[0], newInterval[1]));

        for (int arr[] : intervals) {
            pq.add(new Pair(arr[0], arr[1]));
        }
        while(!pq.isEmpty()){
            Pair temp=pq.poll();
            if(ans.isEmpty()){
                ans.add(temp);
            }
            else{
                Pair prev=ans.peek();
                if(temp.first>=prev.first && temp.first<=prev.second){
                    prev=ans.pop();
                    ans.add(new Pair(Math.min(prev.first,temp.first),Math.max(temp.second,prev.second)));
                }
                else{
                    ans.add(temp);
                }
            }
        }
        int inter[][]=new int[ans.size()][2];
        for(int i=ans.size()-1;i>=0;i--){
            Pair temp=ans.pop();
            inter[i][0]=temp.first;
            inter[i][1]=temp.second;
        }
        return inter;
    }
}

class Pair {
    int first;
    int second;

    Pair(int f, int s) {
        this.first = f;
        this.second = s;
    }
}