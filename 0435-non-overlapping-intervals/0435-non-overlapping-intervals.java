class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->(a.end-b.end));
        for(int arr[]:intervals){
            pq.add(new Pair(arr[0],arr[1]));
        }
        Pair temp=pq.poll();
        int co=1;
        int last=temp.end;
        while(!pq.isEmpty()){
            temp=pq.poll();

            if(temp.st>=last){
                co++;
                last=temp.end;
            }
        }
        return intervals.length-co;

    }
}
class Pair{
    int st,end;
    Pair(int st,int end){
        this.st=st;
        this.end=end;
    }
}